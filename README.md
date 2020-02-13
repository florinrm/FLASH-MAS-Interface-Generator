# FLASH-MAS Interface Generator
Generator for a HTML language, following instructions given by user.

Example for input (YAML file):
```yaml
node:
  name: root
  children:
    - name: child1
      type: button
      children: []
    - name: child2
      children: []
```

A node (an element) is characterized by:
- name
- type
- list of child elements (if it has children, then it's a block, otherwise it's an simple element - e.g. button)
