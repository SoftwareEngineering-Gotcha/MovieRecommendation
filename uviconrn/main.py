from typing import Optional
from fastapi import FastAPI

userdb = {}

app = FastAPI()

@app.get("/")
def read_root():
    return {"hello":"world"}

@app.put("/users/")
def read_item(uid: Optional[str] = None, passwd: Optional[str] = None):
    result = "FAILED"
    if uid != None and passwd != None:
        userdb[uid] = passwd
        result = "SUCCESS"
    return {"uid": uid, "passwd": passwd, "result":result}

@app.get("/users")
def print_item():
    return userdb;

@app.get("/users/_count_")
def print_count():
    return len(userdb)

@app.delete("/users/")
def delete_item(uid: Optional[str] = None):
    result = "FAILED"
    if uid != None:
        temp = userdb.keys()
        if uid in temp:
            del userdb[uid]
            result = "SUCCESS"
            return {"result" : result }
    return {"result" : result }
