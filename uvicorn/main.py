from typing import Optional
from fastapi import FastAPI

app = FastAPI()

userdb = []
class userInfo:
    uid = ""
    passwd = ""
    def __init__(self, uid, passwd):
        self.uid = uid
        self.passwd = passwd

@app.get("/")
def read_root():
    return {"hello":"world"}

@app.put("/users")
def put_user(uid: Optional[str] = None, passwd: Optional[str] =None):
    result = "FAILED"
    if uid != None and passwd != None:
        userdb.append(userInfo(uid,passwd))
        result = "SUCCESS"
    return {"result": result}

@app.delete("/users")
def delete_user(uid: Optional[str] = None):
    result = "FAILED"
    for user in userdb:
        if uid == user.uid:
            userdb.remove(user)
            result = "SUCCESS"
    return {"result": result}

@app.get("/users")
def get_users(uid: Optional[str] = None, passwd: Optional[str] = None):
    result = "FAILED"
    if uid==None and passwd==None:
        return userdb
    for user in userdb:
        if uid == user.uid and passwd == user.passwd:
            result = "SUCCESS"
    return userdb

@app.get("/users/_count_")
def get_users_count():
    return len(userdb)

