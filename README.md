1 ) Create API where you can submit a purchase for a ticket
Post call -- Purchase ticket -- http://localhost:8088/swagger-ui/index.html#/ticket-controller/purchaseTicket

Request Body :
{
  "from": "Bangolre",
  "to": "Mysore",
  "user": {
    "firstName": "Abi",
    "lastName": "Suzil",
    "email": "suzil.g@qbrainx.com",
    "seat": {
      "section": "A",
      "seatNumber": 100
    }
  },
  "pricePaid": "20$"
}

Response Body
ticketId = 1

------------------------------------------------------------------------------------------------------------------------------

2 ) An API that shows the details of the receipt for the user
Get call -- Tickets --http://localhost:8088/swagger-ui/index.html#/ticket-controller/getTicket

Request Body :

ticketId =1 

Response Body :

{
  "from": "Bangolre",
  "to": "Mysore",
  "user": {
    "firstName": "Abi",
    "lastName": "Suzil",
    "email": "suzil.g@qbrainx.com",
    "seat": {
      "section": "B",
      "seatNumber": 101
    }
  },
  "pricePaid": "20$"
}


------------------------------------------------------------------------------------------------------------------------------


3 ) An API that lets you view the users and seat they are allocated by the requested section
Get call -- sections -- http://localhost:8088/swagger-ui/index.html#/ticket-controller/getUsersBySection

Request Body :

section = A


Response Body :

{
  "1": {
    "firstName": "Abi",
    "lastName": "Suzil",
    "email": "suzil.g@qbrainx.com",
    "seat": {
      "section": "A",
      "seatNumber": 100
    }
  }
}

------------------------------------------------------------------------------------------------------------------------------

4 ) An API to remove a user from the train
Delete Call -- removeUser -- http://localhost:8088/swagger-ui/index.html#/ticket-controller/removeUser

Request Body : 
ticketId = 1

Response Body : 

200 status 

------------------------------------------------------------------------------------------------------------------------------

5 ) An API to modify a user's seat
Update Call -- modifySeat -- http://localhost:8088/swagger-ui/index.html#/ticket-controller/modifySeat

Request Body : 
ticketId  = 1 
{
  "section": "B",
  "seatNumber": 101
}

Response Body :

200 status 

------------------------------------------------------------------------------------------------------------------------------
