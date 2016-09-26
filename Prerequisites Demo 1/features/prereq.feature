Feature: Prerequisites
	Scenario: Student enrolls for course
		Given student "000123456" takes course "IT110"
		Given student "000484368" takes course "IT210"
		Given student "000484368" takes course "CS230"
		Then number of courses is 3
		Then number of students is 2

	Scenario: Course has a prereq
		Given course "IT210" has prereq "IT110"
		Then "IT210" has a prereq is "true"

	Scenario: Student with ID
		Given student named "John Doe" has ID "000123456"
		Then "John Doe" is associated with "000123456"

	Scenario Outline: Student enrolls for course
		Given student <ID1> takes course <class1>
		Given student <ID2> takes course <class2>
		Given student <ID3> takes course <class3>
		Given student <ID4> takes course <class4>
		Then number of courses is <totalc>
		And number of students is <totals>

	Examples:
	|ID1			|class1		|ID2			|class2		|ID3			|class3		|ID4 			|class4		|totalc	|totals	|
	|"000123456"	|"IT111"	|"000123456"	|"IT211"	|"000123456"	|"IT401"	|"000123456"	|"CS111" 	|4 		|1		|
	|"000234567" 	|"IT112"	|"000234567"	|"IT212"	|"000234567"	|"IT402"	|"000134567"	|"CS112"	|4 		|2		|
	|"000345678"	|"IT113"	|"000345678"	|"IT213"	|"000345673"	|"IT345"	|"000345634"	|"CS113"	|4 		|3		|
	|"000456789"	|"IT114"	|"000423589"	|"IT214"	|"000456546"	|"IT399"	|"000956789"	|"CS114"	|4 		|4		|
	|"000123450"	|"IT115"	|"000143450"	|"IT215"	|"000153450"	|"IT402"	|"000163450"	|"CS115"	|4 		|4		|

	Scenario Outline: Course has a prereq
		Given course <class> has prereq <prereq>
		Then <class> has a prereq is <bool>

	Examples:
	|class 	|prereq |bool	|
	|"IT111"|"IT101"|"true"	|
	|"IT112"|"IT102"|"true"	|
	|"IT113"|"IT103"|"true"	|

	Scenario Outline: Student with ID
		Given student named <name> has ID <ID>
		Then <name> is associated with <ID>

	Examples:
	|name 			|ID  		|
	|"John Doe"		|"000123456"|
	|"Jane Doe"		|"000234567"|
	|"Joe Don"		|"000345678"|
	|"Joe Dane"		|"000456789"|