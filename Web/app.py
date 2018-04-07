from flask import Flask,render_template,request,redirect,url_for
import sqlite3 as sql
from SQL_execute import GetData, dict_factory

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/health',methods = ['GET','POST'])
def health():
    if request.method == 'GET':
        return render_template('health.html')
    else:
        data = request.form['getData']
        print(data) #dgb
        con = sql.connect('dis.db')
        con.row_factory = sql.Row

        cur = con.cursor()
        cur.execute('SELECT name,symptom from Diseases WHERE name LIKE ?',("%"+data+"%",))

        ret = cur.fetchall()
        con.close()
        print(ret) #dgb
        return render_template('healthInfo.html',infos = ret)

if __name__ == "__main__":
    app.run(debug=True)
