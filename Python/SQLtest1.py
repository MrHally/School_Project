import mysql.connector

mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="",
    database="QLHH"
)
mycursor = mydb.cursor()

sql = "SELECT * FROM HANGHOA"
mycursor.execute(sql)

myresult = mycursor.fetchall()

for x in myresult:
    print(x)