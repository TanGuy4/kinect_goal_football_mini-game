# OpenNI Installation on Windows

May 2014: PrimeSense was bought by Apple at the end of April, and the [OpenNI.org](http://www.openni.org/) website was shut down. Fortunately, several sites have set up archives of the old OpenNI and NITE software, such as [Simple-OpenNI](http://code.google.com/p/simple-openni/) and [Structure Sensor](http://structure.io/openni).

When looking through these archives, it's important to remember that the code examples in my book use OpenNI version 1. It's quite different from version 2, which sports many changes to the skeleton and hand detection functions, resulting in big changes to NITE as well. In other words, you need to find archive copies of version 1 of OpenNI and NITE to run my game. The following instructions explain how to do that.

## 1. Clean Up
Useful freeware tools for cleaning Windows: [Revo Uninstaller](http://www.revouninstaller.com/), [CCleaner](http://www.piriform.com/CCLEANER)

- Use [Revo Uninstaller](http://www.revouninstaller.com/) / [CCleaner](http://www.piriform.com/CCLEANER) to delete any applications that mention 'Kinect', 'Xbox', 'PrimeSense', 'OpenNI' or 'NITE'
- Delete the C:\Program Files\PrimeSense and C:\Program Files\OpenNI directories (or the equivalents for your platform)
- Uninstall any drivers that mention 'Kinect', 'Xbox' or 'PrimeSense' via Window's Device Manager

## 2. Download the Packages
Download the relevant OpenNI/NITE zip file from the [Simple-OpenNI](http://code.google.com/p/simple-openni/) downloads website. Search for "All Downloads" to find suitable versions of OpenNI and NITE for Windows, Linux, and OSX. I recommend the following:

- Windows 32-bit: `OpenNI_NITE_Installer-win32-0.27.zip`
- Windows 64-bit: `OpenNI_NITE_Installer-win64-0.27.zip`
- Linux 32-bit: `OpenNI_NITE_Installer-Linux32-0.27.zip`
- Linux 64-bit: `OpenNI_NITE_Installer-Linux64-0.27.zip`
- OSX: `OpenNI_NITE_Installer-OSX-0.24.zip`

For example, the Windows 32-bit zip file ( `OpenNI_NITE_Installer-win32-0.27.zip`) contains four installers:

- `nite-win32-1.5.2.21-dev.msi`
- `openni-win32-1.5.4.0-dev.msi`
- `SensorKinect092-Bin-Win32-v5.1.2.1.msi`
- `sensor-win32-5.1.2.1-redist.msi`

I've also made that zip file available [here](http://fivedots.coe.psu.ac.th/~ad/kinect/OpenNI_NITE_Installer-win32-0.27.zip); it's 120 MB large.

There are two installers containing the word "sensor", which relate to the SensorKinect driver. It seems that the driver inside `SensorKinect092-Bin-Win32-v5.1.2.1.msi` is compiled using `VC++ 2010` so you must have `Microsoft's VC++ 2010 Redistributable` installed for the driver to correctly execute. The redistributable is inside `sensor-win32-5.1.2.1-redist.msi`.

If you don't want to install the 64-bit version of OpenNI on your 64-bit Windows machine, then you can use the 32-bit installer instead. Some good instructions on how to do that can be found [here](http://ramsrigoutham.com/2012/06/07/installation-of-kinect-on-windows-7-openni-sensor-kinect-and-nite/).

## 3. Installation
Install the four downloaded packages in the order:
1. OpenNI: `openni-win32-1.5.4.0-dev.msi`
2. SensorKinect driver -- there are two steps: first `sensor-win32-5.1.2.1-redist.msi`, and then `SensorKinect092-Bin-Win32-v5.1.2.1.msi`
3. NITE: `nite-win32-1.5.2.21-dev.msi`

Afterwards, check if the software is in the `C:\Program Files\OpenNI\` and `C:\Program Files\PrimeSense\` directories.

To install the three hardware drivers (for motor, audio, and camera), you should:
- Plug the Kinect into your PC and into the mains; this will trigger Windows into installing the drivers, but don't let the installation search for the drivers itself. Instead you should supply their location in `C:\Program Files\PrimeSense\SensorKinect\Driver` afterwards, check if the 3 drivers show up in Windows' Device Manager under a 'PrimeSense' header
- Delete OpenNI's Java CLASSPATH environment variable via Windows' System control panel Advanced tab

## 4. Edit four XML Configuration Files
In `C:\Program Files\PrimeSense\NITE\Data` edit:
- Sample-Scene.xml
- Sample-Training.xml
- Sample-User.xml

In `C:\Program Files\OpenNI\Data` edit:
- SampleConfig.xml

The edits to these XML files are:
- Add the PrimeSense license: ```<License vendor="PrimeSense" key="0KOIk2JeIBYClPWVnMoRKn5cdY4="/> ```
- Add ```<MapOutputMode>``` attributes to all the ```<Configuration>``` subterms: ```<MapOutputMode xRes="640" yRes="480" FPS="30"/> ```

## 5. Test OpenNI and NITE
In `C:\Program Files\OpenNI\Samples\Bin\Release`, run the applications:
- NiSimpleRead.exe
- NiSimpleViewer.exe
- NiViewer.exe,
- NiUserTracker.exe.

In `C:\Program Files\PrimeSense\NITE\Samples\Bin\Release`, run:
- Sample-Boxes.exe