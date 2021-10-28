# Spartronics 4915's Test Bed 2021

## Usage

### Prerequisites

Ensure you have Java 11 installed on your computer and added to `$PATH`.
Visual Studio Code, Git, and the WPILib extension are also helpful for development.

The (highly) recommended way to install these is through [the WPILib installer](https://docs.wpilib.org/en/latest/docs/zero-to-robot/step-2/wpilib-setup.html
).

### Installation

Once your development environment is set up, `clone` this repository to your computer.

Run `./gradlew tasks` to list available Gradle options.

Run `./gradlew build` or use the WPILib extension's `Build Robot Code` option to build or compile the codebase.

Run `./gradlew deploy` or use the WPILib extension's `Deploy Robot Code` option while connected to the robot to build and deploy your code.

## Style Guide

- **Indentation**: Four spaces, no tabs.
- **Braces**: Each brace goes on its own line.
  - This is verbose, but intentionally so - brace errors are common,
    often difficult-to-diagnose, and have caused problems at bad times in the past.
- Line length: Eighty characters or less, as a rule of thumb.
  - This improves legibility and makes it easier to view files side-by-side.
  - The formatter doesn't actually enforce this until lines are 120 characters,
    to give you flexibility around how you'd like to wrap your lines.
- Variable names: `camelCase`.
  - **Member variables**: Prefix with `m`, ex. `mMemberVariable`.
  - **Final constants**: Prefix with `k`, ex. `kFinalConstant`.
  - Parameters: No prefix.
- Class and file names: `PascalCase`.
- Folder names: `lowercase`.
- **Package structure**: `com.spartronics4915.frcXXXX`

(differences from WPILib are in **bold**)

A relatively unopinionated Eclipse-style formatter is included in the `.settings` folder.
This can be run at any time by opening Visual Studio Code's Command Palette (`Ctrl+Shift+P`) and selecting `Format Document`.
