# The Milky Way Contour Catalogue
---
A catalogue based on Axel Mellinger's Milky Way panorama. It contains the contours of 12 levels of brightness of the Milky Way.

### Catalogue creation

- Get public version of [Axel Mellinger's Milky Way panorama](http://galaxy.phy.cmich.edu/~axel/mwpan2/mwpan2_RGB_3600.fits).
- Use [SExtractor](http://www.astromatic.net/software/sextractor) to extract background (Milky Way) from panorama

  Sample shell commands:
  ```
  imgnam=<panorama>

  sex $imgnam \
	-GAIN 1.4 \
	-BACK_SIZE 16 \
	-BACK_FILTERSIZE 3 \
	-CHECKIMAGE_TYPE "BACKGROUND" \
	-CHECKIMAGE_NAME "${imgnam}.sex" \
	-CATALOG_NAME ${imgnam}.cat \
  ```
- Use [SAOImage DS9](http://ds9.si.edu/site/Home.html) to create contour maps from background. Make one contour file for each level to draw different levels in different styles.
- In case of DS9 crashes on output of SExtractor try load/ save output with [Fitswork](http://www.fitswork.de/software/). Then repeat previous step.

### Catalogue explanation
Not done yet.
