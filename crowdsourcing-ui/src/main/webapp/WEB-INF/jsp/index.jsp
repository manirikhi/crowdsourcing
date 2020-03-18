<!DOCTYPE html>
<%@taglib prefix="jwr" uri="http://jawr.net/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" data-ng-app="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
<jwr:script src="/js/ems-core.js" />
<jwr:script src="/js/ems-app.js" />
<jwr:style src="/css/ems-core.css" />
<jwr:style src="/css/ems-app.css" />
<style>
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
</head>
<body>

<jsp:include page='${fileName}'></jsp:include>
	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
</script>
</body>
</html>