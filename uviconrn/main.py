from typing import Optional
from fastapi import FastAPI

app = FastAPI()

@app.get("/")
def read_root():
    return {"hello":"world"}

@app.get("/users")
def read_item(uid: Optional[str] = None, passwd: Optional[str] = None):
    result = "FAILED"
    if uid != None and passwd != None:
        result = "SUCCESS"
    return {"uid": uid, "passwd": passwd, "result":result}
