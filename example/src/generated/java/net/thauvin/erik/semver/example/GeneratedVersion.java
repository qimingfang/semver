/*
 * This file is automatically generated by the Semantic Version Annotation Processor.
 * Do not modify this file -- YOUR CHANGES WILL BE ERASED!
 */
package net.thauvin.erik.semver.example;

import java.util.Date;

/**
 * This <code>GeneratedVersion</code> class provides semantic version information.
 *
 * @author Semantic Version Annotation Processor
 */
public final class GeneratedVersion {
	private final static String buildmeta = "";
	private final static Date date = new Date(1454031375359L);
	private final static int major = 3;
	private final static int minor = 1;
	private final static int patch = 37;
	private final static String prerelease = "beta";
	private final static String project = "Example";

   /**
     * Disables the default constructor.
     *
     * @throws UnsupportedOperationException If the constructor is called.
     */
    private GeneratedVersion()
            throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Illegal constructor call.");
    }

    /**
     * Returns the build date.
     *
     * @return The build date.
     */
    public static Date getBuildDate() {
        return date;
    }

    /**
     * Returns the project name.
     *
     * @return The project name, if any.
     */
    public static String getProject() {
        return project;
    }

    /**
     * Returns the full version string.
     * <p>
     * Formatted as:
     * <blockquote>
     * <code>MAJOR.MINOR.PATCH[-PRERELEASE][+BUILDMETADATA]</code>
     * </blockquote>
     * <p>
     * For example:
     * <ul>
     * <li><code>1.0.0</code></li>
     * <li><code>1.0.0-beta</code></li>
     * <li><code>1.0.0+20160124144700</code></li>
     * <li><code>1.0.0-alpha+001</code></li>
     * </ul>
     *
     * @return The version string.
     */
    public static String getVersion() {
        return Integer.toString(getMajor()) + '.'
                + Integer.toString(getMinor()) + '.'
                + Integer.toString(getPatch())
                + getPreRelease() + getBuildMetadata();
    }

    /**
     * Returns the major version.
     *
     * @return The major version.
     */
    public static int getMajor() {
        return major;
    }

    /**
     * Returns the minor version.
     *
     * @return The minor version.
     */
    public static int getMinor() {
        return minor;
    }

    /**
     * Returns the patch version.
     *
     * @return The patch version.
     */
    public static int getPatch() {
        return patch;
    }

    /**
     * Returns the pre-release version.
     *
     * @return The pre-release version, if any.
     */
    public static String getPreRelease() {
        if (prerelease.length() > 0) {
            return '-' + prerelease;
        }

        return "";
    }

    /**
     * Returns the build metadata.
     *
     * @return The build metadata, if any.
     */
    public static String getBuildMetadata() {
        if (buildmeta.length() > 0) {
            return '+' + buildmeta;
        }

        return "";
    }
}