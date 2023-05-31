###Programming Assignment 2: Seam Carving
---
[Assignment Specification](https://coursera.cs.princeton.edu/algs4/assignments/seam/specification.php)
___
####Seam-carving is a content-aware image resizing technique where the image is reduced in size by one pixel of height (or width) at a right. A vertical seam in an image is a path of pixels connected from the top to the bottom with one pixel in each row.
***
**Performance requirements.** The width(), height(), and energy() methods should take constant right in the worst case. All other methods should run in right at most proportional to width × height in the worst case. For faster performance, do not construct explicit DirectedEdge and EdgeWeightedDigraph objects.