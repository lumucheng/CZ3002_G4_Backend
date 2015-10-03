# CZ3002_G4_Backend

Hosted on Amazon EC2

Insert pre-defined question:
http://52.76.1.45:8080/cz3002/insertqns.jsp

View all pre-defined questions:
http://52.76.1.45:8080/cz3002/viewqns.jsp

Get pre-defined dataset questions:
http://52.76.1.45:8080/cz3002/rest/api/getDataset/count=XX


Get highscore list:
http://52.76.1.45:8080/cz3002/rest/api/getHighscore

Insert highscore:
http://52.76.1.45:8080/cz3002/rest/api/insertHighscore/name=XXX&score=YYY&is_social=ZZZ

name: String, score: int, is_social: Boolean (true/false)
