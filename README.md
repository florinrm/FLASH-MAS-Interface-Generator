# FLASH-MAS Interface Generator
Generator for a HTML language, following instructions given by user.

Example for input (YAML file):
```yaml
configuration:
  inline3: # first line
    blockElements: # elements from first line
      button1: # first button from line
        type: button # element type must be specified
        value: Press here!
        text: sucky ducky
      button2: #second button from first line
        name: Don't press here pls
        type: button
        value: Don't press here pls
        text: plz presssss
  inline2: # second line
    blockElements: # elements from second line
      button1:
        name: JUST F PRESS IT!
        type: button
        text: JUST PRESS IIIITTT
```
