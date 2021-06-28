import requests
import json
import pymysql

conn = pymysql.connect(host='localhost', user='root', password='123456', database='vuework', port=3306)
cursor = conn.cursor()
def save_dataset(sql, data):
    '''
    parm:
    sql: 格式化的sql语句
    data: 将要处理的数据   
    return:      
    ''' 
    try:
        cursor.execute(sql, data)  ## 单行插入数据
        conn.commit()              ## 提交执行
    except Exception as e:
        print(f"数据插入出现错误！错误类型：{e.__class__.__name__},错误明细:{e}")
        conn.rollback()    # 回滚

## https://www.cingta.com/school/ser  ## 原网址 
## 在网址中发现所需数据请求来自于 https://www.cingta.com/school/api/name_uni_list/
url = 'https://www.cingta.com/school/api/name_uni_list/'
header = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0"

## 发起请求
resp = requests.get(url= url,headers={'User-Agent':header})
# print(resp)

# 获取数据
data = resp.json()
# print(len(data)) ## 2
# print(type(data)) ## <class 'dict'>
# print(data.keys()) ## dict_keys(['state', 'data'])

# print(data["state"]) ## 0
# print(data["data"].keys()) ## dict_keys(['list', 'total'])
# print(data["data"]['list']) ## <class 'list'> len = 2787 ##此为所需数据

# print(data["data"]['list'][0])
## {'lineid': 1, 'code': '4111010001', 'schoolname': '北京大学', 'province': '北京市', 'city': '北京市', 'department': '教育部', 'level': '本科', 'type': '一流大学A类,985,211', 'link': 'http://www.pku.edu.cn/'}

for each in data['data']['list']:
    lineid = each['lineid']   ##<class 'int'>
    code = each['code']       ## <class 'str'> 一下全部相同
    schoolname = each['schoolname']
    province = each['province']
    city = each['city']
    department = each['department']
    level = each['level']
    type = each['type']
    link = each['link']
    alldata = (lineid, code, schoolname, province, city, department, level, type, link)

    sql = 'insert into collegesList(lineid, code, schoolname, province, city, department, level, type, link) values(%s, %s, %s, %s, %s, %s, %s, %s, %s);'
    save_dataset(sql, alldata)

cursor.close()
conn.close()