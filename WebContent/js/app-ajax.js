//click
//change
//blur
$(document).ready(
		function() {
			$('#airLines').change(

					function() {
						$('#adultseats').empty();
						$('#childseats').empty();
						$.ajax({
							url : 'GetAirlinesSeatsServlet',
							data : {
								airLines : $('#airLines').val()
							},
							success : function(responseText) {
								var countlist = "";

								countlist = responseText;
								// countlist=responseText.split(',');
								console.log(countlist);
								var adultcount = countlist.substring(2,
										countlist.indexOf("c") - 1).split(",");
								console.log(adultcount);
								var childcount = countlist.substring(
										countlist.indexOf("c") + 2,
										countlist.length).split(",");
								$('#adultseats').append(
										"<option value=''>Select seats"
												+ "</option>");
								for ( var item in adultcount) {

									$('#adultseats').append(
											"<option value=" + adultcount[item]
													+ ">" + adultcount[item]
													+ "</option>");
								}
								$('#childseats').append(
										"<option value=''>Select seats"
												+ "</option>");

								for ( var item in childcount) {
									$('#childseats').append(
											"<option value=" + childcount[item]
													+ ">" + childcount[item]
													+ "</option>");

								}
							}
						});
					});
		});