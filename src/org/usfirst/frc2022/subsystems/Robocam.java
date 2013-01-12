package org.usfirst.frc2022.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.image.RGBImage;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Image processor using NIVision to find "shining" rectangles once an image is
 * filtered with low light. The CriteriaCollection contains the "rules" used to
 * analyze the maximum width of the received rectangles.
 *
 * Modified from original post on
 * http://www.chiefdelphi.com/forums/showthread.php?t=109657
 *
 * @author FRC Team #3381 (original), FRC Team #2022 (modified)
 * @param ip - String of the camera's IP address
 *
 */
public class Robocam extends Subsystem {

    private AxisCamera camera; 				//camera instance
    private CriteriaCollection collection;	//criteria for analyzing image

    /**
     * Creates a new Robocam instance with a minimum width of 30 px and a
     * maximum width of 400 px as well as a minimum height of 40 px and maximum
     * height of 400 px.
     *
     * @author FRC Team #3381 (original), FRC Team #2022 (modified)
     * @param ip - String of the camera's IP address
     * @return
     */
    public Robocam(String ip) {
        camera = AxisCamera.getInstance(ip);
        collection = new CriteriaCollection();
        collection.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 30, 400, false);
        collection.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 40, 400, false);
    }

    /**
     * Analyzes an image taken by a robot's camera, using BinaryImage objects to
     * refine the image, resulting in the center of each rectangle found, if any
     *
     * @author FRC Team #3381 (original), FRC Team #2022 (modified)
     * @param
     * @return
     *
     */
    public ParticleAnalysisReport[] analyze() {
        ParticleAnalysisReport[] finalReport;

        try {
            ColorImage image = camera.getImage();
            //newRGBImage(string filename) for loading an image
            //image.thresholdHSL(100, 120, saturationLow, saturationHigh, luminenceLow, luminenceHigh)
            //BinaryImage thresholdImage = image.thresholdRGB(0, 88, 25, 255, 0, 47);   	// keep green reflection
            //BinaryImage thresholdImage = image.thresholdHSL(43, 66, 100, 256, 0, 250); //targets edog
            BinaryImage thresholdImage = image.thresholdHSL(157, 165, 99, 256, 80, 250); //targets the tape, using green light
            BinaryImage bigObjectsImage = thresholdImage.removeSmallObjects(false, 2);  // remove small artifacts
            BinaryImage convexHullImage = bigObjectsImage.convexHull(false);          	// fill in occluded rectangles
            BinaryImage filteredImage = convexHullImage.particleFilter(collection);     // find filled in rectangles

            ParticleAnalysisReport[] reports = filteredImage.getOrderedParticleAnalysisReports();  // get list of results
            finalReport = reports;
            SmartDashboard.putNumber("Number of artifacts found: ", reports.length);		//Tell Drivers Station artifacts found
            for (int i = 0; i < reports.length; i++) {                                	// print results
                ParticleAnalysisReport r = reports[i];

                SmartDashboard.putNumber("Artifact :             ", i);
                SmartDashboard.putNumber("Center (x) normalized: ", r.center_mass_x_normalized);
                SmartDashboard.putNumber("Center (y) normalized: ", r.center_mass_y_normalized);
                SmartDashboard.putNumber("Height:                ", r.imageHeight);
                SmartDashboard.putNumber("Width:                 ", r.imageWidth);
            }

            /* MUST USE FREE FUNCTION: all images are currently allocated in C structures */
            filteredImage.free();
            convexHullImage.free();
            bigObjectsImage.free();
            thresholdImage.free();
            image.free();
        } //end analyze()
        catch (AxisCameraException e) {
            finalReport = null;
            e.printStackTrace();
        } catch (NIVisionException ex) {
            finalReport = null;
            ex.printStackTrace();
        }

        return finalReport;
    }

    /**
     * Default command for the Robocam subsystem
     */
    protected void initDefaultCommand() {
    }
}
