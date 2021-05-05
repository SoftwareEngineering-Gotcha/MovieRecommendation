
from fastapi import FastAPI

app = FastAPI()
app.router.redirect_slashes = False

userdb = {}

userdb["initId1"] = "initpassWd1"
userdb["initId2"] = "initpassWd2"

@app.get("/")
def read_root():
    return {"hello":"world"}

@app.put("/users/")
def put_user(uid, passwd):
    result = "FAILED"
    a = userdb.keys()
    if uid in a:
        result = "FAILED"
        return { "result" : result}
    if uid != None and passwd != None:
        userdb[uid]=passwd
        result = "SUCCESS"
    return {"result": result}

@app.delete("/users/")
def delete_user(uid):
    result = "FAILED"
    a = userdb.keys()
    if uid in a:
        del userdb[uid]
        result = "SUCCESS"
    return {"result": result}

@app.get("/users")
def get_users():
    return userdb

@app.get("/users/_count_")
def get_users_count():
    return len(userdb)
