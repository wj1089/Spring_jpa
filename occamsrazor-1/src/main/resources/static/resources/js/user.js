"use strict"
var user = user || {} //user네임스페이스에 json을 담는것이다, {} = Member mem = "null"; {}으로 결국 user가 json이 된다.
user =(()=>{//=>람다까지 달린다!  어나니머스는 반복적으로 new를 때리는것이 아니고 new하나에 계속 입력을할수있다.
	let init =()=>{ //초기화함수, 
		alert('1')
		onCreate()
	}
	let onCreate =() =>{//on만들어지자마자라는 뜻
		setContentView()
		$('#register_a').click(e=>{
	     	e.preventDefault()
	     	location.href = "admin"
	     })
	     $('#access_a').click(e=>{
	    	 
	     })
	     
	}
	let setContentView =() =>{
		 $('#kcdc').css({ width: '80%', height: '900px' }).addClass('border_black center')
	     $('#tr_1').css({ width: '80%', height: '50px' }).addClass('border_black center')
	     $('#menu').css({ width: '80%', height: '50px' }).addClass('border_black center')
	     $('#kcdc td').addClass('border_black', 'width_full')
	}
	return {init}//클로져				
})()//즉시실행

