NetBeans Plugin for Scala
=========================

## Project Information
This is a unofficial release of dcaoyan's [scala language](http://http://www.scala-lang.org/) plugin for the Netbeans Platform for the . In the case of a maven scala project, no local installation of scala is needed. It enables:
 * syntax checking
 * syntax highlighting
 * auto-completion
 * pretty formatter
 * occurrences mark
 * brace matching
 * indentation
 * code folding
 * function navigator
 * go to declaration
 * project management 
 * shell console

It's is specially useful if you are a maven user.

### Notice ###
The Ant based project will be removed soon, which, by far, is not under improving any more. Please use sbt/maven based project.

### Where to start ?
The official project central point is [https://github.com/dcaoyuan/nbscala](), but it has been unattended for some time, while some other places where the project was hosted before were are abandoned. The purpose of this fork is to make dcaoyuan's code (including all public available patches) work "as is" on Apache Netbeans releases (from 9.0 onwards).

### Community
This has mostly been a one man project with some patches supplied by different people. For questions and bug reports use the [issue tracker](https://github.com/dtosti/nbscala/issues). If you have forked the official project and do you want to share your patches feel free to send them or request a pull.

## Installation

### Installation via NetBeans Update Center
Unfortunately, the plugin is not currently available on [http://plugins.netbeans.org](http://plugins.netbeans.org), therefore it cannot be installed via the NetBeans Update Center, but only via manual installation.

### Manual Installation
Make sure you don't have an old version installed: check your netbeans installation for a 'nbscala' directory: if it exists, just delete it.

1. Build the latest release.
2. Put all .nbm files from their target directory in a new directory 'nbscala' under your netbeans installation.
3. Start Netbeans.
4. Select Tools -> Plugins -> Downloaded -> Add Plugins...
5. Select all extracted files from the 'nbscala' directory.
6. Accept the license and the installation of unsigned plugins. 

### Installation Notes:

 * After installation, it's always better to restart NetBeans
 * You may need to delete NetBeans' old cache to get improved features working. To find the cache location, read the netbeans.conf at:

        $NetBeansInstallationPlace/etc/netbeans.conf

## Build Instructions

### Requirement - Running:
* Java 1.8+
* NetBeans 9+

### Requirement - Building:
* Java 1.8 (for master branch)
* Java 1.8 (for 2.9.x branch)
* Maven 2.x/3.x 
* NetBeans 9+

### Branches:
* master -- tracking Scala 2.10.x and 2.11.x currently
* 2.9.x  -- for Scala 2.9.x

### Set system environment variable for building.

    MAVEN_OPTS=-Xss8M

or even more:

    MAVEN_OPTS=-Xss8M -Xmx2048M

### Build all nbms

    cd nbscala
    mvn clean install

### Generate auto-update site:

    cd nbscala
    mvn nbm:autoupdate

the nbms and update site can be found at nbscala/target/netbeans_site

### Run/Debug ide:

    cd nbscala
    mvn nbm:cluster

To run:

    mvn nbm:run-ide

To debug:

    mvn nbm:run-ide -Pdebug-ide

Build-Run-Cycle: (after changed module was successfuly built)
	
    mvn nbm:cluster nbm:run-ide

Build-Debug-Cycle: (after changed module was successfuly built)

    mvn nbm:cluster nbm:run-ide -Pdebug-ide

## Project Details

The Project targets version 2.10.x and 2.11.x of the Scala release.

## Scala Console Integration

### A new Scala shell console was implemented since Feb 27, 2013

### To open it, right click on project, and choose "Open Scala Console"

### Features:

* Be aware of project's classpath that could be imported, new, run under console
* Popup auto-completion when press \<tab\>
* Applied also to Java SE projects and Maven projects

## SBT Integration

### Only Scala-2.10+ is supported under for SBT integration 

* That is, always try to set your project's Scala version to 2.10+ in Build.scala or build.sbt: 

        scalaVersion := "2.10.0"

### Supported features

* Recognize sbt project and open in NetBeans
* Open sbt console in NetBeans (Right click on sbt project, choose "Open Sbt")
* Jump to compile error lines

### How to

* nbsbt-plugin 1.1.2+ has been deployed to repo.scala-sbt.org, that means it will be automatilly resolved when you run sbt):

* Add nbsbt to your plugin definition file. You can use either the global one at  **~/.sbt/0.13/plugins/plugins.sbt** or the project-specific one at **PROJECT_DIR/project/plugins.sbt**

        addSbtPlugin("org.netbeans.nbsbt" % "nbsbt-plugin" % "1.1.4")


## FAQ


**Q**: NetBeans' response becomes slower after a while.

**A**: Edit your NetBeans configuration file (NetBeansInstallationPlace/etc/netbeans.conf), add -J-Xmx2048M (or bigger)


**Q**: How to navigate SBT project's dependency sources.

**A**: You should have SBT download the dependency's sources via sbt command: `sbt updateClassifiers`, please see http://www.scala-sbt.org/0.13.1/docs/Detailed-Topics/Library-Management.html#download-sources. 


**Q**: I got:

    [error] sbt.IncompatiblePluginsException: Binary incompatibility in plugins detected.

**A**: Try to remove published nbsbt plugin from your local .ivy2 repository and sbt plugins cache:

    rm -r ~/.ivy2/local/org.netbeans.nbsbt
    rm -r ~/.sbt/0.13/plugins/target

and redo 'publish-local' for the NetBeans sbt plugin <https://github.com/dcaoyuan/nbsbt>.


**Q**: I got:

    [error] Not a valid command: netbeans
    [error] Expected '/'
    [error] Expected ':'
    [error] Not a valid key: netbeans (similar: test, tags, streams)
    [error] netbeans
    [error]         ^

**A**: Try to remove the project/target folder under your project base directory, there may be something cached here, and was not reflected to the newest condition.


**Q**: What will this plugin do upon my project?

**A**: It will generate a NetBeans project definition file ".classpath_nb" for each project.


**Q**: It seems there are some suspicious error hints displayed on the edited source file, how can I do?

**A**: There may be varies causes, you can try open another source file, then switch back to this one, the error hints may have disappeared. If not, right click in editing window, choose 'Reset Scala Parser', and try the steps mentioned previous again.


**Q**: My project's definition was changed, how to reflect these changes to NetBeans.

**A**: Right click on the root project, choose "Reload Project".


**Q**: Exiting from Scala console leaves terminal unusable.

**A**: Under some unix-like environment, scala interactive console started with some stty setting, but not for NetBeans's integrated one. You can try 'reset' after quit from NetBeans.
