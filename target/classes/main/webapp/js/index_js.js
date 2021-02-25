window.onload = function(){
	// 寻找所有list
	var lists = document.getElementsByClassName("list");
	for(var i = 0; i < lists.length; i++){
		lists[i].onmouseover = function(){
			var list_curs = this.getElementsByClassName("list_cur");
			if(list_curs.length > 0){
				list_curs[0].style.display = "block";
				list_curs[0].style.border = "1px solid #eee";
				list_curs[0].style.borderTop = "none";
				this.style.backgroundColor = "#fff";
				this.style.border = "1px solid #eee";
				this.style.borderBottom = "none";
				list_curs[0].style.display = "block";
			}
		}
		lists[i].onmouseout = function(){
			var list_curs = this.getElementsByClassName("list_cur");
			if(list_curs.length > 0){
				this.style.backgroundColor = "";
				this.style.border = "";
				list_curs[0].style.display = "none";
			}
		}
	}
};