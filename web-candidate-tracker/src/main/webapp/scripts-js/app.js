const urlOriginal = window.location.href;
if ((urlOriginal.split('?')).length > 1) {
	const urlNueva = urlOriginal.replace(urlOriginal.split('CandidateControllerServlet').pop(), '');
	location.replace(urlNueva);
}