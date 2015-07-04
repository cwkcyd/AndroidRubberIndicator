package com.liangfeizc;

/**
 * Created by liangfeizc on 7/4/15.
 */
public class PathPoint {
    /**
     * The possible path operations that describe how to move from a preceding PathPoint to the
     * location described by this PathPoint.
     */

    public static final int MOVE = 0;
    public static final int LINE = 1;
    public static final int CURVE = 2;
    public static final int ARC = 3;

    /**
     * The location of this PathPoint.
     */
    float mX, mY;

    /**
     * The first control point, if any, for PathPoint of type CURVE
     */
    float mControl0X, mControl0Y;

    /**
     * The second control point, if any, for PathPoint of type CURVE
     */
    float mControl1X, mControl1Y;

    /**
     * The motion described by the path from the previous PathPoint in an AnimatorPath
     * to the location of this PathPoint. This can be one of MOVE, LINE or CURVE.
     */
    int mOperation;

    /**
     * Line/Move constructor
     */
    public PathPoint(int operation, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
    }

    /**
     * Curve constructor
     */
    public PathPoint(float c0X, float c0Y, float c1X, float c1Y, float x, float y) {
        mControl0X = c0X;
        mControl0Y = c0Y;
        mControl1X = c1X;
        mControl1Y = c1Y;
        mX = x;
        mY = y;
        mOperation = CURVE;
    }

    /**
     * Constructs and returns a PathPoint object that describes a line to the given xy location.
     */
    public static PathPoint lineTo(float x, float y) {
        return new PathPoint(LINE, x, y);
    }

    /**
     * Constructs and returns a PathPoint object that describes a cubic Bezier curve to the
     * given xy location with the control points at c0 and c1.
     */
    public static PathPoint curveTo(float c0X, float c0Y, float c1X, float c1Y, float x, float y) {
        return new PathPoint(c0X, c0Y, c1X, c1Y, x, y);
    }

    /**
     * Constructs and returns a PathPoint object that describes a discontinuous move to the given
     * xy location.
     */
    public static PathPoint moveTo(float x, float y) {
        return new PathPoint(MOVE, x, y);
    }
}