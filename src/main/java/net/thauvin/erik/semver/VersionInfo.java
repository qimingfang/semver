/*
 * VersionInfo.java
 *
 * Copyright (c) 2016-2017, Erik C. Thauvin (erik@thauvin.net)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 *   Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 *   Neither the name of this project nor the names of its contributors may be
 *   used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.thauvin.erik.semver;

/**
 * The <code>VersionInfo</code> class is used to hold and retrieve the semantic version values.
 *
 * @author <a href="mailto:erik@thauvin.net" target="_blank">Erik C. Thauvin</a>
 * @created 2016-01-16
 * @since 1.0
 */
public class VersionInfo {
    private final long epoch = System.currentTimeMillis();

    private String buildMeta;
    private String className;
    private int major;
    private int minor;
    private String packageName;
    private int patch;
    private String preRelease;
    private String project;


    /**
     * Creates a new object with default values.
     */
    public VersionInfo() {
        major = Constants.DEFAULT_MAJOR;
        minor = Constants.DEFAULT_MINOR;
        patch = Constants.DEFAULT_PATCH;
        buildMeta = Constants.EMPTY;
        preRelease = Constants.EMPTY;
        project = Constants.EMPTY;
        className = Constants.DEFAULT_CLASS_NAME;
        packageName = Constants.EMPTY;
    }

    /**
     * Creates a new object with values from a {@link net.thauvin.erik.semver.Version Version} object.
     *
     * @param version The version object.
     */
    public VersionInfo(final Version version) {
        major = version.major();
        minor = version.minor();
        patch = version.patch();
        buildMeta = version.buildMeta();
        preRelease = version.preRelease();
        project = version.project();
        className = version.className();
        packageName = version.packageName();
    }

    /**
     * Returns the build meta-data.
     *
     * @return The build meta-data.
     */
    public String getBuildMeta() {
        return buildMeta;
    }

    /**
     * Sets the build meta-data.
     *
     * @param buildMeta The new build meta-data.
     */
    public void setBuildMeta(final String buildMeta) {
        this.buildMeta = buildMeta;
    }

    /**
     * Returns the class name.
     *
     * @return The class name.
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the class name.
     *
     * @param className The new class name.
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Returns the build epoch/Unix timestamp.
     *
     * @return The build epoch.
     */
    public long getEpoch() {
        return epoch;
    }

    /**
     * Returns the major version.
     *
     * @return The major version.
     */
    public int getMajor() {
        return major;
    }

    /**
     * Sets the major version.
     *
     * @param major The new major version.
     */
    public void setMajor(final int major) {
        this.major = major;
    }

    /**
     * Returns the major version.
     *
     * @return The major version.
     */
    public int getMinor() {
        return minor;
    }

    /**
     * Sets the minor version.
     *
     * @param minor The new minor version.
     */
    public void setMinor(final int minor) {
        this.minor = minor;
    }

    /**
     * Returns the package name.
     *
     * @return The package name.
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * Sets the package name.
     *
     * @param packageName The new package name.
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * Returns the patch version.
     *
     * @return The patch version.
     */
    public int getPatch() {
        return patch;
    }

    /**
     * Sets the patch version.
     *
     * @param patch The new patch version.
     */
    public void setPatch(final int patch) {
        this.patch = patch;
    }

    /**
     * Returns the pre-release version.
     *
     * @return The pre-release version.
     */
    public String getPreRelease() {
        return preRelease;
    }

    /**
     * Sets the pre-release version.
     *
     * @param preRelease The new pre-release version.
     */
    public void setPreRelease(final String preRelease) {
        this.preRelease = preRelease;
    }

    /**
     * Returns the project name.
     *
     * @return The project name.
     */
    public String getProject() {
        return project;
    }

    /**
     * Sets the project name.
     *
     * @param project The new project name.
     */
    public void setProject(final String project) {
        this.project = project;
    }

    /**
     * Returns the full version string.
     * <p>
     * Formatted as:
     * <blockquote><code>MAJOR.MINOR.PATCH[-PRERELEASE][+BUILDMETADATA]</code></blockquote>
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
    public String getVersion() {
        return Integer.toString(major)
                + '.'
                + Integer.toString(minor)
                + '.'
                + Integer.toString(patch)
                + (preRelease.length() > 0 ? '-' + preRelease : "")
                + (buildMeta.length() > 0 ? '+' + buildMeta : "");
    }
}