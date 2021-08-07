/*==================== SHOW Sidebar ====================*/
// @ts-check
"use strict";
const showSidebar = function (headerToggle, navbarId) {
	const toggleBtn = document.getElementById(headerToggle);
	const nav = document.getElementById(navbarId);

	// Validate that variables exist
	if (headerToggle && navbarId) {
		toggleBtn.addEventListener("click", () => {
			// We add the show-menu class to the div tag with the nav__menu class
			nav.classList.toggle("show-menu");
			// change icon
			toggleBtn.classList.toggle("bx-x");
		});
	}
};
showSidebar("header-toggle", "navbar");

/*==================== LINK ACTIVE ====================*/
const linkColor = document.querySelectorAll(".nav__link");

const colorLink = function () {
	linkColor.forEach((link) => link.classList.remove("active"));
	this.classList.add("active");
};

linkColor.forEach((link) => link.addEventListener("click", colorLink));
