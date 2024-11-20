# Generator - C++

## Prerequisites

### Windows

1. Install CMake:
   - Download the latest CMake installer from [cmake.org](https://cmake.org/download/)
   - Choose the Windows x64 Installer option
   - Run the installer and make sure to select "Add CMake to PATH" during installation

2. Install a C++ compiler:
   - Install Visual Studio Community Edition from [visualstudio.microsoft.com](https://visualstudio.microsoft.com/downloads/)
   - During installation, select "Desktop development with C++" workload
   - Or install MinGW-w64 if you prefer using GCC

### Linux

1. Install CMake and C++ compiler:

For Ubuntu/Debian:
```bash
sudo apt update
sudo apt install cmake g++ build-essential
```

For Fedora:
```bash
sudo dnf install cmake gcc-c++ make
```

For Arch Linux:
```bash
sudo pacman -S cmake gcc make
```

## Building and Running the Project

### Windows

1. Open Command Prompt or PowerShell in your project directory
2. Build the project with a single command:
```bash
cmake -B build . && cmake --build build --config Release
```
3. Run the application:
```bash
.\build\Release\generator.exe
```

### Linux

1. Open Terminal in your project directory
2. Build the project with a single command:
```bash
cmake -B build . && cmake --build build
```
3. Run the application:
```bash
./build/generator
```

## Project Structure

- `generator.cpp` - Main source file containing the car data generator
- `CMakeLists.txt` - CMake configuration file
- `queue/` - Directory where generated JSON files will be stored (created automatically)
- `build/` - Build directory (created automatically)

## Rebuilding

If you want to rebuild from scratch:
1. Delete the `build` directory
2. Run the build command again

Or simply run the build command again to rebuild only changed files.

## Dependencies

- nlohmann/json (automatically downloaded by CMake)
- C++17 compatible compiler
- CMake 3.10 or higher

## If you have any problems:

### Windows
- If you get "'cmake' is not recognized", restart your terminal after installing CMake
- Make sure you have Visual Studio with C++ workload or MinGW-w64 installed
- Run Command Prompt or PowerShell as Administrator if you encounter permission issues

### Linux
- If CMake fails to install, try running `sudo apt update` first
- If you get permission denied errors, prefix commands with `sudo`
- Make sure your compiler is properly installed with `g++ --version`