var docSpec = {
	elements: {
		// 1..n elements
		"Chart" : {
			menu: [{
				caption: "Delete element",
				action: Xonomy.deleteElement,
				hideIf: function(jsElement) {
					return jsElement.parent().getChildElements("Chart").length == 1;
				}
			}]
		},
		// 0..1 element
		"Epoch" : {
			menu: [{
				caption: "Delete element",
				action: Xonomy.deleteElement
			}],
			mustBeBefore: ["Chart"]
		},
		// 1 element
		"ChartaCaeli": {
			menu: [{
				// 0..1 attribute
				caption: "Add attribute @name",
				action: Xonomy.newAttribute,
				actionParameter: {name: "name"},
				hideIf: function(jsElement){
					return jsElement.hasAttribute("name");
				}
			}, {
				// 0..1 element
				caption: "Add <Epoch>",
				action: Xonomy.newElementChild,
				actionParameter: "<Epoch/>",
				hideIf: function(jsElement) {
					return jsElement.hasChildElement("Epoch");
				}
			}, {
				// 1..n elements
				caption: "Add <Chart>",
				action: Xonomy.newElementChild,
				actionParameter: "<Chart/>"
			}],
			attributes: {
				// 0..1 attribute
				"name": {
					asker: Xonomy.askString,
					menu: [{
						caption: "Delete attribute",
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
