<!DOCTYPE html>
<%@taglib prefix="jwr" uri="http://jawr.net/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" data-ng-app="loginApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
<jwr:script src="/js/ems-core.js" />
<jwr:script src="/js/ems-app.js" />
<jwr:style src="/css/ems-core.css" />
<jwr:style src="/css/ems-app.css" />
<style>
@font-face {
  font-family: "Material-Design-Icons";
  src: url("resources/libs/materialize/font/material-design-icons/Material-Design-Icons.eot?#iefix") format("embedded-opentype"), 
  url("resources/libs/materialize/font/material-design-icons/Material-Design-Icons.woff2") format("woff2"), 
  url("resources/libs/materialize/font/material-design-icons/Material-Design-Icons.woff") format("woff"), 
  url("resources/libs/materialize/font/material-design-icons/Material-Design-Icons.ttf") format("truetype"), 
  url("resources/libs/materialize/font/material-design-icons/Material-Design-Icons.svg#Material-Design-Icons") format("svg");
  font-weight: normal;
  font-style: normal;
}
@font-face {
	font-family: 'FontAwesome';
	src:
		url('resources/theme/font-awesome/fonts/fontawesome-webfont.eot?v=4.3.0');
	src:
		url('resources/theme/font-awesome/fonts/fontawesome-webfont.eot?#iefix&v=4.3.0')
		format('embedded-opentype'),
		url('resources/theme/font-awesome/fonts/fontawesome-webfont.woff2?v=4.3.0')
		format('woff2'),
		url('resources/theme/font-awesome/fonts/fontawesome-webfont.woff?v=4.3.0')
		format('woff'),
		url('resources/theme/font-awesome/fonts/fontawesome-webfont.ttf?v=4.3.0')
		format('truetype'),
		url('resources/theme/font-awesome/fonts/fontawesome-webfont.svg?v=4.3.0#fontawesomeregular')
		format('svg');
}
</style>
<style type="text/css">
html,
body {
    height: 100%;
}
html {
    display: table;
    margin: auto;
}
body {
    display: table-cell;
    vertical-align: middle;
}
.margin {
  margin: 0 !important;
}
</style>
</head>
<body class="blue" ng-controller="LoginController">
	<div ui-view="loginView"></div>
</body>
</html>