package frontend;

import java.awt.*;

/* For this frontend framework, SWING, the following rules must be applied
 * to gracefully clone the Windows Calculator application with near
 * approximations.
 */
public class SwingDesignRules {

    private static int top;
    private static int left;
    private static int bottom;
    private static int right;
    private static boolean initialized = false;

    public static void init() {
        initialized = true;
        top = 2;
        left = 5;
        bottom = 3;
        right = 0;
    }

    public static void checkInitState() {
        if (!initialized) {
            init();
        }
    }

    public static Insets distanceBetweenPushButtons(int i) {
        checkInitState();
        // top buttons
        if (i < 8) {
            // top buttons
            if (i < 7) {
                return new Insets(0, left, bottom, right);
            }
            // top-left corner button
            else if (i == 0) {
                return new Insets(0, left, bottom, right);
            }
            // top-right corner button
            else if (i == 7) {
                return new Insets(0, left, bottom, 0);
            }
        }
        // left buttons
        else if (i >= 8 && i < 39) {
            // left buttons
            if (i % 8 == 0) {
                return new Insets(top, left, bottom, right);
            }
            // right buttons
            else if (i - 7 % 8 == 0) {
                return new Insets(top, left, bottom, 0);
            }
            // middle buttons
            else {
                return new Insets(top, left, bottom, right);
            }
        }
        // bottom buttons
        else if (i > 38) {
            // bottom buttons
            if (i < 46) {
                return new Insets(top, left, 0, right);
            }
            // bottom-right corner button
            else if (i == 39) {
                return new Insets(top, left, 0, 0);
            }
            // bottom-left corner button
            else if (i == 40) {
                return new Insets(top, left, 0, bottom);
            }
        }
        return new Insets(0, 0, 0, 0);
    }

}
