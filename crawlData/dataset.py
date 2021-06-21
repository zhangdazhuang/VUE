import pymysql

# 数据管理类
class DataManager():

    def __init__(self):
        # 链接数据库，若数据库不存在则创建
        self.conn = pymysql.connect(host='localhost', user='root', password='123456', database='vuework', port=3306)
        # 创建游标对象
        self.cursor = self.conn.cursor()

    def save_data(self, sql, data):
        '''
        parm:
        sql: 格式化的sql语句
        data: 将要处理的数据   

        return:      
        ''' 
        try:
            self.cursor.execute(sql, data)  ## 单行插入数据
            self.conn.commit()              ## 提交执行
        except Exception as e:
            print(f"数据插入出现错误！错误类型：{e.__class__.__name__},错误明细:{e}")
            self.conn.rollback()    # 回滚

    def __del__(self):
        self.cursor.close()
        self.conn.close()