<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Js Exercise</title>
</head>
<body>
	<h1>Hi Exercise for javascript</h1>
	<p id="demo">A paragraph </p>
	<p id="demo1">Input1 input2</p>
	<p id="demo2"></p>
	<p id="demo3"></p>
	<p id="demo4"></p>
	<p id="demo5"></p>
	<p id="demo6"></p>
	<p id="demo7"></p>
	<p id="demo8"></p>
	<button type="button" onclick="myFunction()">Try press</button>
	<br></br>
	<!-- this shows the value on the button itself  -->
	<button type="button" onclick="this.innerHTML=Date()">Show Date</button> 
	
	
<script type="text/javascript">
/*
 * JS can declare num=with/without decimal
   alphanumeric as ""/''
   case sensitive
   equal to '=='
   operation:
	   ** = exponentiation(ES2016)
	   ++ = increment by 1
	   -- = decrement
	   += = concatenate string or x = x + ?
  	Comparison operator:
  	  	=== =>	equal value & type
  	  	!== =>	!=value | !=type
  	  	?	=>	ternary operator
  	   	&&	=> 	&
  	   	||	=> 	|
  	   	!	=>	!
  	  	x ** y produces the same result as Math.pow(x,y)
  	  	var length = 16;                               // Number
		var lastName = "Johnson";                      // String
		var x = {firstName:"John", lastName:"Doe"};    // Object

		Array 	=> var cars = ["Saab", "Volvo", "BMW"];
		Object 	=> var person = {firstName:"John", lastName:"Doe", age:50, eyeColor:"blue"};
		The typeof operator returns "object" for objects, arrays, and null.
		The typeof operator does not return "object" for functions.

		onchange		An HTML element has been changed
		onclick			The user clicks an HTML element
		onmouseover		The user moves the mouse over an HTML element
		onmouseout		The user moves the mouse away from an HTML element
		onkeydown		The user pushes a keyboard key
		onload			The browser has finished loading the page

		var str = "Please locate where 'locate' occurs!";
		var pos = str.indexOf("locate");		//first occurrence
		var pos = str.lastIndexOf("locate");	//last occurrence
		var pos = str.indexOf("locate", 15);  	//Search start at pos 15
		var pos = str.search("locate");			//searches a string for a specified value and returns the position of the match
		The search() method cannot take a second start position argument.
		The indexOf() method cannot take powerful search values (regular expressions).

		If you omit the second parameter, substr() will slice out the rest of the string.
		slice(start, end)		=extracts a part of a string and returns the extracted part in a new string, if parameter is negative, the position is counted from the end of the string
		substring(start, end)	=substring() is similar to slice(),substring() cannot accept negative indexes
		substr(start, length)	=second parameter specifies the length of the extracted part
		substring(start, end)
		substr(start, length)
		
		str = "Please visit Microsoft!";
		var n = str.replace("Microsoft", "W3Schools"); 

		str = "Please visit Microsoft and Microsoft!";
		var n = str.replace(/Microsoft/g, "W3Schools"); //replace all

		var text1 = "Hello World!";       // String
		var text2 = text1.toUpperCase();  // text2 is text1 converted to upper
		var text2 = text1.toLowerCase();  // text2 is text1 converted to lower
		var txt = "a,b,c,d,e";   // String
		txt.split(",");          // Split on commas
		txt.split(" ");          // Split on spaces
		txt.split("|");          // Split on pipe
		var txt = "Hello";       // String
		txt.split("");           // Split in characters

		var x = 123e5;    // 12300000
		var y = 123e-5;   // 0.00123

		toFixed() returns a string, with the number written with a specified number of decimals:
		toPrecision() returns a string, with a number written with a specified length:

		Number() can be used to convert JavaScript variables to numbers,return NaN for non-numeric:
		parseInt() parses a string and returns a whole number. Spaces are allowed. Only the first number is returned
		parseFloat() parses a string and returns a number. Spaces are allowed. Only the first number is returned

		The pop() method removes the last element from an array:
		The shift() method removes the first array element and "shifts" all other elements to a lower index
		The unshift() method adds a new element to an array (at the beginning), and "unshifts" older elements:
		cars.splice(1,1,"Jaguar") -> Add Jaguar at index 1 n remove 1 index
		The concat() method does not change the existing arrays. It always returns a new array
		The slice() method creates a new array. It does not remove any elements from the source array.
		The sort() method sorts an array alphabetically:However, if numbers are sorted as strings, "25" is bigger than "100", because "2" is bigger than "1"
		The reverse() method reverses the elements in an array	
 */
var inp1,inp2,inp3;
inp1 = '1';
inp2 = 10;
inp3 = "Hi";

//Obj example
var person = {
		fname : "Nasaruddin",
		lname : "helmi",
		age : 24,
		race : "Malays",
		retiredAge : function(){	//Can hav method in obj	
			return this.age+40;
		}
}

function myFunction(){

	var x = 0.2 + 0.1	//Test for number data
	var cars = ['BMW','Audi','VellFire'];
	document.getElementById("demo").innerHTML = "Paragraph changed "+inp3;
	document.getElementById("demo1").innerHTML = "inp1="+inp1+" inp2="+inp2+" and inp1+inp2="+inp1+inp2; //will treat next inp2 as string
	document.getElementById("demo3").innerHTML = "1 == '7' ="+(1 == '7')+" & "+"1 == 1 ="+(1==1); //return boolean
	document.getElementById("demo4").innerHTML = person.fname+" "+person["lname"]+" is"+person.age+" years old"+ " retired at "+person.retiredAge();	//get object atr,retiredAge() to get the fn
	document.getElementById("demo5").innerHTML = typeof 0 +"<br>"+ typeof person.age+"<br>"+
												 typeof person.fname+"<br>"+typeof true+"<br>"+
												 typeof {fname : "Nasaruddin",lname : "helmi",age : 24,race : "Malays"}		//return "Object" type
												 +"<br>"+"length name is "+person.fname.length	//Use built in fn .length
												 +"<br>"+"It\'s alright.";	// backslash escape character
	document.getElementById("demo6").innerHTML = "(0.3 + 0.1) = "+(0.3+0.1)+" x,0.2+0.1 = "+x+"<br>"+
												 "convert int to String="+(123+10).toString()+100+"<br>"+
												 "toFixed(2) method = "+9.656.toFixed(2)+" toFixed(3) method = "+6.6567878.toFixed(3)+"<br>"+
												 "use Number() function,Number(true) = "+Number(true)+" ,Number('10 33')="+Number("10 33")+"<br>"+
												  parseInt("10") + "<br>" +
												  parseInt("10.33") + "<br>" +
												  parseInt("10 6") + "<br>" +  
												  parseInt("10 years") + "<br>" +  
												  parseInt("years 10") + "<br>"+
												  parseFloat("10") + "<br>" +
												  parseFloat("10.33") + "<br>" +
												  parseFloat("10 6") + "<br>" +  
												  parseFloat("10 years") + "<br>" +
												  parseFloat("years 10") + "<br>" +
												  "MAX_VALUE = "+Number.MAX_VALUE + "<br>"+
												  "MIN_VALUE = "+Number.MIN_VALUE + "<br>"+
												  "POSTIVE_INFINITY = "+Number.POSTIVE_INFINITY + "<br>"+
												  "NEGATIVE_INFINITY = "+Number.NEGATIVE_INFINITY + "<br>"+
												  100 / "Apple";  
	document.getElementById("demo7").innerHTML = cars+"<br>"+
												 "number of elem:"+cars.length;
	cars.push("Ferrari");
	delete cars[2];
	var cars2 = cars.slice(0);
	document.getElementById("demo8").innerHTML = cars+"<br>"+
												 cars.toString()+"<br>"+
												 cars.join("//")+"<br>"+
												 cars.splice(1,1,"Jaguar")+"<br>"+
												 cars+"<br>"+
												 "Here is cars2 = "+cars2;		
												 																					 
	window.alert("Button is pressed");//popup alert window
}

document.getElementById("demo2").innerHTML = 4 * 2;	//writing into HTML element, user innerHTML
document.write(10+10);	//write() for testing purpose only
console.log("inside debugging mode");	//can see in debugging mode


</script>
</body>
</html>