"use strict"
var user = user || {} // new user , name space
//user는 글로벌 선언 (Java Resources 내에서)
//Member member = null
user = (()=>{ // 즉시실행구조 , 모듈패턴
	const WHEN_ERROR = `호출하는 JS 파일을 찾지 못했습니다.`
	let admin_vue
	let init = () => {
		admin_vue = `/resources/vue/admin_vue.js` //스테이트값은 백틱`
		onCreate()
	}
	//member = new Member()
	
	let onCreate = () =>{ //만들어지자마자 , 기능
		$.when(
				$.getScript(admin_vue)
		).done(()=>{
			setContentView()
			$('#register_Button').click(e => {
				$('#content').empty()
				$('#content').html(adminVue.join())
				$(`<input type="button" />`)
				.attr({'value':'등록하기'})
				.css({width: '200px', height: '100px', 'font-size': '30px'})
				.appendTo('#button_box')
				.click(e => {
					alert('등록버튼 클릭')
				})
	       
	        	$(`<input type="button" />`)
	        	.attr({'value':'취소하기'})
	        	.css({width: '200px', height: '100px', 'font-size': '30px'})
	        	.appendTo('#button_box')
	        	.click(e => {
	        		alert('취소버튼 클릭')
	        	})
			 })	
	        $('#access_Button').click(e=> {
		    	 alert('접소오옥')
	        	$('#content').empty()
	        	$('#content').html(adminVue.login())
	        	$(`<input type="button"/>`)
	        	.attr({'value':'로그인'})
	        	.appendTo('#login_box')
	        	.click(e => {
	        		e.preventDefault()
	        		location.href="/admin"
//	        		$.ajax({
//	        			url : ``,
//	        			type : `post`,
//	        			data : JSON.stringify({
//	        				
//	        			}),
//	        			dataType : `json`,
//	        			contentType : `application/json`,
//	        			success : d=> {
//	        				location.href = "/admin"
//	        			},
//	        			error : (r,x,e) => {
//	        				alert(r.status)
//	        			}
//	        		})
					
				})
				$(`<input type="button"/>`)
	        	.attr({value:"취소"})
	        	.appendTo('#login_box')
	        	.click(e => {
	        		e.preventDefault()
	        		
				})
	        })
		}).fail(()=>{
			alert(WHEN_ERROR)
		})
		
	}
	let setContentView = () =>{ // 속성
		$('#kcdc').css({ width: '80%', height: '900px' }).addClass('border_black center')
        $('#tr_1').css({ width: '80%', height: '50px' }).addClass('border_black center')
        $('#menu').css({ width: '80%', height: '50px' }).addClass('border_black center')
        $('#kcdc td').addClass('border_black', 'width_full')
        
	}
	return {init}
	
})()