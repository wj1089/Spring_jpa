"use strict"
var admin = admin||{}
admin =(()=>{
	let init =()=>{
		alert('1')
		onCreate()
	}
	let onCreate =()=>{
		alert('2')
		setContentViews()
	}
	let setContentViews=()=>{
		alert('3')
	}
	return {init}
})()
