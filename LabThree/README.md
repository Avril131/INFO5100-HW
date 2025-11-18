# LabThree - Color Circle GUI

A simple Java Swing GUI application that displays a circle with color selection functionality.

## Features

- Display a circle (initially clear/no color)
- Dropdown menu to select colors (Red, Blue, Green, Yellow, Orange, Pink)
- Text output field showing the selected color name
- Circle fills with the selected color

## How to Run

### Using Maven:

```bash
# Compile
mvn clean compile

# Run
mvn exec:java -Dexec.mainClass="com.example.App"
```

### Using Java directly:

```bash
# Compile
mvn clean package

# Run
java -cp target/classes com.example.App
```

## Project Structure

- `App.java` - Main entry point
- `ColorCircleFrame.java` - Main GUI frame with dropdown and output field
- `CirclePanel.java` - Custom panel to draw and fill the circle

