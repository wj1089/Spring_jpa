"use strict"

var admin =admin || {}
admin =(()=>{
	const WHEN_ERROR =`호출하는 JS파일을 찾지 못했습니다.`
		let admin_vue;
	let init =() =>{
		admin_vue =`/resources/vue/admin_vue.js`
			onCreate()
	}
	let onCreate =() =>{
		$.when(
			  $.getScript(admin_vue)
			).done(()=>{
					setContentView()
						$.getJSON('/users',d =>{
							$('#total_count').text('총회원수 : '+d.length)
							$.each(d,(i,j)=>{
								$(`<tr>
	                            <td>
	                                <span>${i+1}</span>
	                            </td>
	                            <td>
	                                <span>${j.userid}</span>
	                            </td>
	                             <td>
	                                <span id = "user_`+(i+1)+`"}</span>
	                            </td>
	                           <td>
	                                <span>${j.ssn}</span>
	                            </td>
	                            <td>
	                               <span>${j.email}</span>
	                            </td>
	                            <td>
	                                <span>${j.phoneNumber}</span>
	                            </td>
	                            <td>
	                                <span>${j.registerDate}</span>
	                            </td>
	                        </tr>`).appendTo('#userData')
	                        
	                        $(`<a>${j.name}</a>`)
	                        .css({cursor:'pointer',color:'blue'})
	                        .appendTo("#user_"+(i+1))
	                        .click(e=>{
	                        	$('#userData').empty()
	                        	$(user_vue.detail())
	                        	.appendTo('#userData')
	                        	$.getJSON(`/users/${j.userId}`,d=>{
	                        		$('#userId').text(d.userId)
	                        	})
	                        })
						})//each
					})//getJSON
					
				$('#item_list').click(e=>{
					e.preventDefault()
					$('#content').empty()
					$('#content').html(`<table id="items">
	                        <tr>
	                            <th>
	                                <span>No.</span>
	                            </th>
	                            <th>
	                                <span>분실물 ID</span>
	                            </th>
	                             <th>
	                                <span>습득물품명</span>
	                            </th>
	                           <th>
	                                <span>습득일자</span>
	                            </th>
	                            <th>
	                                <span>습득물분류</span>
	                            </th>
	                            <th>
	                                <span>습득위치(지하철)</span>
	                            </th>
	                        </tr>
	                        
	                    </table>`)
	                    $.getJSON(`/items`, d=>{
	                    	$.each(d, (i, j)=>{
	                    		$(`<tr>
	                            <td>
	                                <span>No.</span>
	                            </td>
	                            <td>
	                                <span>${j.itemid}</span>
	                            </td>
	                             <td>
	                                <span>${j.itemName}</span>
	                            </td>
	                           <td>
	                                <span>${j.takenDate}</span>
	                            </td>
	                            <td>
	                                <span>${j.category}</span>
	                            </td>
	                            <td>
	                                <span>${j.takenPostion}</span>
	                            </td>
	                        </tr>`).appendTo('#items')
	                    	})
	                    	
	                    })
				})
				
			}).fail(()=>{
				alert(WHEN_ERROR)
			})
			
		}
	let setContentView=()=>{
		$('userData tr').first().css({'background-color':'yellow'})
	}
	return {init}
})()


