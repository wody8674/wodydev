
var txt_obj = document.getElementById("text_value");

txt_obj.addEventListener("mousedown", on_MouseDownn);

function on_MouseDownn(e) {
	
	if (e.cacelable) {
		e.preventDefault();
	}
	
}