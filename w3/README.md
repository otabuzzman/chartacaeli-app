# Charta Caeli Website
A mobile first web frontend to the Charta Caeli star chart creation web service.

#### Xonomy web XML editor
Install XMLStarlet
- needs libxml2 and libxslt
- expects /usr/include/libxml

Cues for Cygwin
- install libxml2 and libxml2-devel packages
- install libxslt and libxslt-devel packages
- `cd /usr/include ; ln -s libxml2/libxml libxml`

Check document specification for missing elements, attributes and patterns.
```
# elements
for e in `xml sel -t -v "//xs:element/@name" chartacaeli.xsd | sort -u` ; do \
	echo -n $e " " ; egrep -c "^\s*\"$e\"" w3/lib/chartacaeli.xsd.js ; done |\
	grep '0$'

# attributes
for a in `xml sel -t -v "//xs:attribute/@name" chartacaeli.xsd | sort -u` ; do \
	echo -n $a " " ; egrep -c "^\s*\"$a\"" w3/lib/chartacaeli.xsd.js ; done |\
	grep '0$'

# patterns
for p in `xml sel -t -v "//xs:pattern/@value" chartacaeli.xsd | sort -u` ; do \
	echo -n $p " " ; egrep -c "^\s*{value: \"$p\"" w3/lib/chartacaeli.xsd.js ; done |\
	grep '0$'
```

#### Content preparation
Favicon creation
- Icon sketched with Google Slides but defined with Microsoft Powerpoint because Slides lacks some GUI features (e.g. setting arbitrary linewidths, capstyles and numerical rotation angles).
- Icon text in Justinian font made with Powerpoint. Set background transparent. Save text element as graphic via context menu.
- Combine icon and text images with Slides.

#### Style guide
Basic color palette and usage. Click on hex value to get derived palettes.

|Color|Usage|
|-----|-----|
|[#e81669](https://mycolor.space/?hex=%23e81669&sub=1) ([adjust](http://hslpicker.com/#e81669)) |Primary color of application.|
|[#892894](https://mycolor.space/?hex=%23892894&sub=1) ([adjust](http://hslpicker.com/#892894)) ||
|[#6a1f6b](https://mycolor.space/?hex=%236a1f6b&sub=1) ([adjust](http://hslpicker.com/#6a1f6b)) ||
|[#341344](https://mycolor.space/?hex=%23341344&sub=1) ([adjust](http://hslpicker.com/#341344)) ||
|[#0e1659](https://mycolor.space/?hex=%230e1659&sub=1) ([adjust](http://hslpicker.com/#0e1659)) ||
|[#3e39e8](https://mycolor.space/?hex=%233e39e8&sub=1) ([adjust](http://hslpicker.com/#3e39e8)) ||
|[#323232](https://mycolor.space/?hex=%23323232&sub=1) ([adjust](http://hslpicker.com/#323232)) |Background of brandicon.ico icon file, font color on bright background.|
|[#e7e7e7](https://mycolor.space/?hex=%23e7e7e7&sub=1) ([adjust](http://hslpicker.com/#e7e7e7)) |Font color on dark background in case of small font size or faint typography.|
|[#dadada](https://mycolor.space/?hex=%23dadada&sub=1) ([adjust](http://hslpicker.com/#dadada)) |Dimmed font color on dark background in case of large font size or strong typography.|

Subordinate styles of buttons and links.

#### Thoughts on links
Purposes of links in running text is provision of background information or to give credit to the efforts of individual projects used by the site. Another reason is to ease access to sites which might somewhat tricky to find with Google even if propper keywords are given.

*Rules of thumb*
- No reference of sites everbody knows (e.g. Amazon, Google, Micosoft).
- Only one reference at first occurence.
- URLs should be limited to the host part as site structures are subject to changes.
- Preference of Wikipedia entries because site structure of Wikipedia is considered stable (based on the assumption that entries are kept up-to-date).
- References of books on Amazon with unambiguous search queries because direct links tend to be very long.
- Unsecure sites referenced with unambiguous Google search queries resulting (ideally) in a top-ranked result.

|Type|Comment|
|----|-------|
|Navigation menu entry|Primary color 10% darkened for `:hover` and 15% for `:active`.|
|URL in text (inline)|Same as for navigation menu entries. No text decorations.|

#### Helpful links
- [CSS reference]( https://www.w3schools.com/cssref/default.asp) on [w3schools.com](https://www.w3schools.com/)
- [YT tutorial](https://www.youtube.com/watch?v=emBwAyYBkC4) about a simple modern looking webpage. Actually this video started the w3 project.
- [YT tutorial](https://www.youtube.com/watch?v=eIWRbvE1B2E) on how to setup a responsive [Bootstrap](https://getbootstrap.com/docs/4.2/getting-started/introduction/) webpage from scratch
- Discussion about [using IMG element or background-image property](https://stackoverflow.com/questions/492809/when-to-use-img-vs-css-background-image)
- Thoughts on [using style tags outside CSS stylesheets](https://www.elegantthemes.com/blog/resources/when-and-why-to-use-the-style-tag-outside-of-css-stylesheets)
- [Blog post](https://icons8.com/articles/choosing-the-right-size-and-format-for-icons/) on how to choose right icon sizes
- SO article on [best practices for where to add event listeners](https://stackoverflow.com/questions/26104525/best-practices-for-where-to-add-event-listeners)

#### Questions
