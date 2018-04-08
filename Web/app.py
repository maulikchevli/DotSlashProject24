from flask import Flask,render_template,request,redirect,url_for,jsonify
import sqlite3 as sql

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/health',methods = ['GET','POST'])
def health():
    if request.method == 'GET':
        return render_template('health.html')
    else:
        disease = request.form['getDisease']
        symptoms=request.form['getSymptom']
        con = sql.connect('dis.db')
        con.row_factory = sql.Row

        cur = con.cursor()
        if symptoms=='' and disease!='':            
            cur.execute('SELECT name,symptom from Diseases WHERE name LIKE ?',("%"+disease+"%",))
        elif symptoms!='' and disease=='':
            cur.execute('SELECT name,symptom from Diseases WHERE symptoms LIKE ?',("%"+symptoms+"%",))
        elif symptoms!='' and disease!='':
            cur.execute('SELECT name,symptom from Diseases WHERE name LIKE ?',("%"+disease+"%",))
        else:
            cur.execute('SELECT name,symptom from Diseases')
        

        dis = cur.fetchall()

        con.close()

        return render_template('healthInfo.html',infos = dis)

@app.route('/symptoms/<disease>',methods = ['GET'])
def symptoms(disease):
    '''disease = [
    {
        'id': 1,
        'title': u'Buy groceries',
        'description': u'Milk, Cheese, Pizza, Fruit, Tylenol',
        'done': False
    },
    {
        'id': 2,
        'title': u'Learn Python',
        'description': u'Need to find a good Python tutorial on the web',
        'done': False
    }
]'''
    con = sql.connect('dis.db')
    con.row_factory = dict_factory

    cur = con.cursor()
    cur.execute('SELECT name,symptom from Diseases WHERE name LIKE ?',("%"+disease+"%",))

    products = cur.fetchall()
    con.close()

    return jsonify(products)

    #return jsonify({'tasks' : tasks})

if __name__ == "__main__":
    app.run(debug=True)
