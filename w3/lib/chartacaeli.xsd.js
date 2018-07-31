/*
top-level elements are supposed to create by start(). no add/ delete methods.
other elements have both methods but delete only if there are no child elements.
the idea behind is to prevent from accidential removal of possibly large structures.
drawback is some inconvenience in case of intended removal of those structures
as this has to be done element by element and layer by layer starting at the deepest.

issues:
- canDropTo and duplicateElement
 */

var docSpec = {
	elements: {
		"HorizonEquatorial": {
			menu: [{
				caption: "add \@@name",
				action: Xonomy.newAttribute,
				actionParameter: {name: "name"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("name");
				}
			}, {
				caption: "add \@@practicality",
				action: Xonomy.newAttribute,
				actionParameter: {name: "practicality"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("practicality");
				}
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement,
			}],
			attributes: {
				"name": {
					asker: Xonomy.askString,
					menu: [{
						caption: "delete",
						action: Xonomy.deleteAttribute
					}]
				},
				"practicality": {
					asker: Xonomy.askPicklist,
					askerParameter: [
						{value: "none"},
						{value: "seldom"},
						{value: "sometimes"},
						{value: "frequent"},
						{value: "always"}
					]
				}
			}
		},
		"HorizonLocal": {
			menu: [{
				caption: "add \@@name",
				action: Xonomy.newAttribute,
				actionParameter: {name: "name"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("name");
				}
			}, {
				caption: "add \@@practicality",
				action: Xonomy.newAttribute,
				actionParameter: {name: "practicality"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("practicality");
				}
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement,
			}],
			attributes: {
				"name": {
					asker: Xonomy.askString,
					menu: [{
						caption: "delete",
						action: Xonomy.deleteAttribute
					}]
				},
				"practicality": {
					asker: Xonomy.askPicklist,
					askerParameter: [
						{value: "none"},
						{value: "seldom"},
						{value: "sometimes"},
						{value: "frequent"},
						{value: "always"}
					]
				}
			}
		},
		"HorizonEcliptical": {
			menu: [{
				caption: "add \@@name",
				action: Xonomy.newAttribute,
				actionParameter: {name: "name"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("name");
				}
			}, {
				caption: "add \@@practicality",
				action: Xonomy.newAttribute,
				actionParameter: {name: "practicality"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("practicality");
				}
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement,
			}],
			attributes: {
				"name": {
					asker: Xonomy.askString,
					menu: [{
						caption: "delete",
						action: Xonomy.deleteAttribute
					}]
				},
				"practicality": {
					asker: Xonomy.askPicklist,
					askerParameter: [
						{value: "none"},
						{value: "seldom"},
						{value: "sometimes"},
						{value: "frequent"},
						{value: "always"}
					]
				}
			}
		},
		"HorizonGalactic": {
			menu: [{
				caption: "add \@@name",
				action: Xonomy.newAttribute,
				actionParameter: {name: "name"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("name");
				}
			}, {
				caption: "add \@@practicality",
				action: Xonomy.newAttribute,
				actionParameter: {name: "practicality"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("practicality");
				}
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement,
			}],
			attributes: {
				"name": {
					asker: Xonomy.askString,
					menu: [{
						caption: "delete",
						action: Xonomy.deleteAttribute
					}]
				},
				"practicality": {
					asker: Xonomy.askPicklist,
					askerParameter: [
						{value: "none"},
						{value: "seldom"},
						{value: "sometimes"},
						{value: "frequent"},
						{value: "always"}
					]
				}
			}
		},
		"ChartPage": {
			menu: [{
				caption: "add \@@name",
				action: Xonomy.newAttribute,
				actionParameter: {name: "name"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("name");
				}
			}, {
				caption: "add \@@size",
				action: Xonomy.newAttribute,
				actionParameter: {name: "size"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("size");
				}
			}, {
				caption: "add \@@view",
				action: Xonomy.newAttribute,
				actionParameter: {name: "view"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("view");
				}
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement,
			}],
			attributes: {
				"name": {
					asker: Xonomy.askString,
					menu: [{
						caption: "delete",
						action: Xonomy.deleteAttribute
					}]
				},
				"size": {
					asker: Xonomy.askOpenPicklist,
					askerParameter: [
						{value: "a0"},
						{value: "a1"},
						{value: "a2"},
						{value: "a3"},
						{value: "a4"},
						{value: "a5"}
					]
				},
				"view": {
					asker: Xonomy.askString
				}
			},
			mustBeBefore: ["Oblique", "Horizon"]
		},
		"Oblique": {
			menu: [{
				caption: "@delete",
				action: Xonomy.deleteElement,
				hideIf: function(jsElement) {
					return jsElement.hasElements();
				}
			}],
			mustBeBefore: ["Horizon"]
		},
		"Horizon": {
			menu: [{
				caption: "add <HorizonEquatorial>",
				action: Xonomy.newElementChild,
				actionParameter: "<HorizonEquatorial/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("HorizonEquatorial") ||
								jsElement.hasChildElement("HorizonLocal") ||
								jsElement.hasChildElement("HorizonEcliptical") ||
								jsElement.hasChildElement("HorizonGalactic");
				}
			}, {
				caption: "add <HorizonLocal>",
				action: Xonomy.newElementChild,
				actionParameter: "<HorizonLocal/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("HorizonEquatorial") ||
								jsElement.hasChildElement("HorizonLocal") ||
								jsElement.hasChildElement("HorizonEcliptical") ||
								jsElement.hasChildElement("HorizonGalactic");
				}
			}, {
				caption: "add <HorizonEcliptical>",
				action: Xonomy.newElementChild,
				actionParameter: "<HorizonEcliptical/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("HorizonEquatorial") ||
								jsElement.hasChildElement("HorizonLocal") ||
								jsElement.hasChildElement("HorizonEcliptical") ||
								jsElement.hasChildElement("HorizonGalactic");
				}
			}, {
				caption: "add <HorizonGalactic>",
				action: Xonomy.newElementChild,
				actionParameter: "<HorizonGalactic/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("HorizonEquatorial") ||
								jsElement.hasChildElement("HorizonLocal") ||
								jsElement.hasChildElement("HorizonEcliptical") ||
								jsElement.hasChildElement("HorizonGalactic");
				}
			}, {
				caption: "@duplicate",
				action: Xonomy.duplicateElement
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement,
				hideIf: function(jsElement) {
					return jsElement.hasElements();
				}
			}],
			canDropTo: ["ChartAzimuthal", "ChartPseudoCylindrical"]
		},
		"HMS": {
			menu: [{
				caption: "add \@@neg",
				action: Xonomy.newAttribute,
				actionParameter: {name: "neg"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("neg");
				}
			}, {
				caption: "add \@@hrs",
				action: Xonomy.newAttribute,
				actionParameter: {name: "hrs"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("hrs");
				}
			}, {
				caption: "add \@@min",
				action: Xonomy.newAttribute,
				actionParameter: {name: "min"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("min");
				}
			}, {
				caption: "add \@@sec",
				action: Xonomy.newAttribute,
				actionParameter: {name: "sec"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("sec");
				}
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement
			}],
			attributes: {
				"neg": {
					asker: Xonomy.askString
				},
				"hrs": {
					asker: Xonomy.askString
				},
				"min": {
					asker: Xonomy.askString
				},
				"sec": {
					asker: Xonomy.askString
				}
			}
		},
		"Rational": {
			menu: [{
				caption: "add \@@value",
				action: Xonomy.newAttribute,
				actionParameter: {name: "value"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("value");
				}
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement
			}]
		},
		"YMD": {
			menu: [{
				caption: "add \@@y",
				action: Xonomy.newAttribute,
				actionParameter: {name: "y"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("y");
				}
			}, {
				caption: "add \@@m",
				action: Xonomy.newAttribute,
				actionParameter: {name: "m"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("m");
				}
			}, {
				caption: "add \@@d",
				action: Xonomy.newAttribute,
				actionParameter: {name: "d"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("d");
				}
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement
			}],
			attributes: {
				"y": {
					asker: Xonomy.askString
				},
				"m": {
					asker: Xonomy.askString
				},
				"d": {
					asker: Xonomy.askString
				}
			},
			mustBeBefore: ["Time"]
		},
		"Time": {
			menu: [{
				caption: "add \@@standard",
				action: Xonomy.newAttribute,
				actionParameter: {name: "standard"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("standard");
				}				
			}, {
				caption: "add <HMS>",
				action: Xonomy.newElementChild,
				actionParameter: "<HMS/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("HMS") ||
								jsElement.hasChildElement("Rational");
				}
			}, {
				caption: "add <Rational>",
				action: Xonomy.newElementChild,
				actionParameter: "<Rational/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("HMS") ||
								jsElement.hasChildElement("Rational");
				}
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement,
				hideIf: function(jsElement) {
					return jsElement.hasElements();
				}
			}],
			attributes: {
				"standard": {
					asker: Xonomy.askString,
				}
			},
		},
		"Calendar": {
			menu: [{
				caption: "add <YMD>",
				action: Xonomy.newElementChild,
				actionParameter: "<YMD/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("YMD");
				}
			}, {
				caption: "add <Time>",
				action: Xonomy.newElementChild,
				actionParameter: "<Time/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("Time");
				}
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement,
				hideIf: function(jsElement) {
					return jsElement.hasElements();
				}
			}],
			mustBeBefore: ["Omega"],
		},
		"JD": {
			menu: [{
				caption: "add \@@value",
				action: Xonomy.newAttribute,
				actionParameter: {name: "value"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("value");
				}
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement
			}],
			attributes: {
				"value": {
					asker: Xonomy.askString
				}
			},
			mustBeBefore: ["Omega"],
		},
		"Omega": {
			menu: [{
				caption: "add <Calendar>",
				action: Xonomy.newElementChild,
				actionParameter: "<Calendar/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("Calendar") ||
								jsElement.hasChildElement("JD");
				}
			}, {
				caption: "add <JD>",
				action: Xonomy.newElementChild,
				actionParameter: "<JD/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("Calendar") ||
								jsElement.hasChildElement("JD");
				}
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement,
				hideIf: function(jsElement) {
					return jsElement.hasElements();
				}
			}],
		},
		"ChartAzimuthal": {
			menu: [{
				caption: "add \@@name",
				action: Xonomy.newAttribute,
				actionParameter: {name: "name"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("name");
				}
			}, {
				caption: "add \@@scale",
				action: Xonomy.newAttribute,
				actionParameter: {name: "scale"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("scale");
				}
			}, {
				caption: "add \@@projection",
				action: Xonomy.newAttribute,
				actionParameter: {name: "projection"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("projection");
				}
			}, {
				caption: "add <ChartPage>",
				action: Xonomy.newElementChild,
				actionParameter: "<ChartPage/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("ChartPage");
				}
			}, {
				caption: "add <Oblique>",
				action: Xonomy.newElementChild,
				actionParameter: "<Oblique/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("Oblique");
				}
			}, {
				caption: "add <Horizon>",
				action: Xonomy.newElementChild,
				actionParameter: "<Horizon/>"
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement,
				hideIf: function(jsElement) {
					return jsElement.hasElements();
				}
			}],
			attributes: {
				"name": {
					asker: Xonomy.askString,
					menu: [{
						caption: "delete",
						action: Xonomy.deleteAttribute
					}]
				},
				"scale": {
					asker: Xonomy.askString
				},
				"projection": {
					asker: Xonomy.askPicklist,
					askerParameter: [
						{value: "orthographic"},
						{value: "stereographic"}
					]
				}
			}
		},
		"ChartPseudoCylindrical": {
			menu: [{
				caption: "add \@@name",
				action: Xonomy.newAttribute,
				actionParameter: {name: "name"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("name");
				}
			}, {
				caption: "add \@@scale",
				action: Xonomy.newAttribute,
				actionParameter: {name: "scale"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("scale");
				}
			}, {
				caption: "add \@@projection",
				action: Xonomy.newAttribute,
				actionParameter: {name: "projection"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("projection");
				}
			}, {
				caption: "add <ChartPage>",
				action: Xonomy.newElementChild,
				actionParameter: "<ChartPage/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("ChartPage");
				}
			}, {
				caption: "add <Oblique>",
				action: Xonomy.newElementChild,
				actionParameter: "<Oblique/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("Oblique");
				}
			}, {
				caption: "add <Horizon>",
				action: Xonomy.newElementChild,
				actionParameter: "<Horizon/>"
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement,
				hideIf: function(jsElement) {
					return jsElement.hasElements();
				}
			}],
			attributes: {
				"name": {
					asker: Xonomy.askString,
					menu: [{
						caption: "delete",
						action: Xonomy.deleteAttribute
					}],
				},
				"scale": {
					asker: Xonomy.askString,
				},
				"projection": {
					asker: Xonomy.askPicklist,
					askerParameter: [
						{value: "mollweide"}
					]
				}
			}
		},
		"Epoch": {
			menu: [{
				caption: "add <Calendar>",
				action: Xonomy.newElementChild,
				actionParameter: "<Calendar/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("Calendar") ||
								jsElement.hasChildElement("JD");
				}
			}, {
				caption: "add <JD>",
				action: Xonomy.newElementChild,
				actionParameter: "<JD/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("Calendar") ||
								jsElement.hasChildElement("JD");
				}
			}, {
				caption: "add <Omega>",
				action: Xonomy.newElementChild,
				actionParameter: "<Omega/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("Omega");
				}
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement,
				hideIf: function(jsElement) {
					return jsElement.hasElements();
				}
			}],
			mustBeBefore: ["Chart"]
		},
		"Chart": {
			menu: [{
				caption: "add <ChartAzimuthal>",
				action: Xonomy.newElementChild,
				actionParameter: "<ChartAzimuthal/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("ChartAzimuthal") ||
								jsElement.hasChildElement("ChartPseudoCylindrical");
				}
			}, {
				caption: "add <ChartPseudoCylindrical>",
				action: Xonomy.newElementChild,
				actionParameter: "<ChartPseudoCylindrical/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("ChartAzimuthal") ||
								jsElement.hasChildElement("ChartPseudoCylindrical");
				}
			}, {
				caption: "@duplicate",
				action: Xonomy.duplicateElement
			}, {
				caption: "@delete",
				action: Xonomy.deleteElement,
				hideIf: function(jsElement) {
					return jsElement.hasElements();
				}
			}],
			canDropTo: ["ChartaCaeli"]
		},
		"ChartaCaeli": {
			menu: [{
				// occurance 0..1
				caption: "add \@@name",
				action: Xonomy.newAttribute,
				actionParameter: {name: "name"},
				hideIf: function(jsElement) {
					return jsElement.hasAttribute("name");
				}
			}, {
				// occurance 0..1
				caption: "add <Epoch>",
				action: Xonomy.newElementChild,
				actionParameter: "<Epoch/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("Epoch");
				}
			}, {
				// occurance 1..n
				caption: "add <Chart>",
				action: Xonomy.newElementChild,
				actionParameter: "<Chart/>"
			}],
			attributes: {
				"name": {
					asker: Xonomy.askString,
					menu: [{
						caption: "delete",
						action: Xonomy.deleteAttribute
					}]
				}
			}
		}
	},
	onchange: function() {
		console.log("document changed");
	},
	validate: function() {
		console.log("validating...done");
	}
};