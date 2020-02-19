# FLASH-MAS Interface Generator
Generator for a HTML language, following instructions given by user.

Example for page building input (YAML file):
```yaml
platformType: html
node:
  name: root
  children:
    - name: child1
      type: button
      children: []
    - name: button2
      type: button
      children: []
    - name: child2
      children:
        - name: button1
          type: button
          text: press it
        - name: button2
          type: button
        - name: button3
          type: button
    - name: child3
      children:
        - name: button1
          type: button
        - name: button2
          type: button
```

A node (an element) is characterized by:
- name
- type
- list of child elements (if it has children, then it's a block, otherwise it's an simple element - e.g. button)
