import unittest
from api2018.Sendhttp import SendHttp
from api2018 import Common
import json
import requests

url = "/fgadmin/address/new"
list_url = "/fgadmin/address/list"
del_url= "/fgadmin/address/delete"

#沈梦琪 添加地址操作类
class Action(unittest.TestCase):
    def user_login(self):
        user = {"password":"netease123","phoneArea":"86","phoneNumber":"2000000000121"}
        return Common.getcookies(user)

    def count(self):
        res = SendHttp().sent_get_bycookies(list_url, self.user_login())
        count = res['result']["list"]
        return count.__len__()

    def del_address(self):
        res = SendHttp().sent_get_bycookies(list_url, self.user_login())
        count = res['result']["list"]
        if(count.__len__() > 1):
            para = {"id": count[0]["id"]}
            res = SendHttp().send_post_bycookie(del_url,self.user_login(),para)
            # print("收货地址已删除")
        else:
            print("收货地址为空")

    def default_para(self):
        if(self.count() == 6):
            self.del_address()
        para = {
            "receiverName": "张三",
            "cellPhone": "12345678901",
            "addressDetail": "浙江大学",
            "province": "浙江省",
            "city": "浙江市",
            "area": "滨江区"
        }
        res = SendHttp().send_post_bycookie(url, self.user_login(),para)
        return res

    def para(self, *paras):
        if (self.count() == 6):
            self.del_address()
        para={
            "receiverName": paras[0],
            "cellPhone": paras[1],
            "addressDetail": paras[2],
            "province": paras[3],
            "city": paras[4],
            "area": paras[5]
            }
        res = SendHttp().send_post_bycookie(url, self.user_login(),para)
        return res

    def type_para(self, key, value):
        if (self.count() == 6):
            self.del_address()
        if key == "receiverName":
            para = {
                "receiverName": value,
                "cellPhone": "12345678901",
                "addressDetail": "浙江大学",
                "province": "浙江省",
                "city": "浙江市",
                "area": "滨江区"
            }
        elif key == "cellPhone":
            para = {
                "receiverName": "张三",
                "cellPhone": value,
                "addressDetail": "浙江大学",
                "province": "浙江省",
                "city": "浙江市",
                "area": "滨江区"
            }
        elif key == "addressDetail":
            para = {
                "receiverName": "张三",
                "cellPhone": "12345678901",
                "addressDetail": value,
                "province": "浙江省",
                "city": "浙江市",
                "area": "滨江区"
            }
        elif key == "province":
            para = {
                "receiverName": "张三",
                "cellPhone": "12345678901",
                "addressDetail": "浙江大学",
                "province": value,
                "city": "浙江市",
                "area": "滨江区"
            }
        elif key == "city":
            para = {
                "receiverName": "张三",
                "cellPhone": "12345678901",
                "addressDetail": "浙江大学",
                "province": "浙江省",
                "city": value,
                "area": "滨江区"
            }
        elif key == "area":
            para = {
                "receiverName": "张三",
                "cellPhone": "12345678901",
                "addressDetail": "浙江大学",
                "province": "浙江省",
                "city": "浙江市",
                "area": value
            }
        else:
            print("参数不存在")
        res = SendHttp().send_post_bycookie(url, self.user_login(),para)
        return res

    def lack_para(self, lack):
        if (self.count() == 6):
            self.del_address()
        if lack == "receiverName":
            para = {
                "cellPhone": "12345678901",
                "addressDetail": "浙江大学",
                "province": "浙江省",
                "city": "杭州市",
                "area": "滨江区"
            }
        elif lack == "cellPhone":
            para = {
                "receiverName": "张三",
                "addressDetail": "浙江大学",
                "province": "浙江省",
                "city": "杭州市",
                "area": "滨江区"
            }
        elif lack == "addressDetail":
            para = {
                "receiverName": "张三",
                "cellPhone": "12345678901",
                "province": "浙江省",
                "city": "杭州市",
                "area": "滨江区"
            }
        elif lack == "province":
            para = {
                "receiverName": "张三",
                "cellPhone": "12345678901",
                "addressDetail": "浙江大学",
                "city": "杭州市",
                "area": "滨江区"
            }
        elif lack == "city":
            para = {
                "receiverName": "张三",
                "cellPhone": "12345678901",
                "addressDetail": "浙江大学",
                "province": "浙江省",
                "area": "滨江区"
            }
        elif lack == "area":
            para = {
                "receiverName": "张三",
                "cellPhone": "12345678901",
                "addressDetail": "浙江大学",
                "province": "浙江省",
                "city": "杭州市"
            }
        else:
            print(lack+"地址参数不存在")
        res = SendHttp().send_post_bycookie(url, self.user_login(),para)
        return res


    def error_para(self, *error):
        if (self.count() == 6):
            self.del_address()
        if error.__len__() == 1:
            if error[0] == "area":
                para = {
                    "receiverName": "张三",
                    "cellPhone": "12345678901",
                    "addressDetail": "南京大学",
                    "province": "江苏省",
                    "city": "南京市",
                    "area": "西湖区"
                }
            elif error[0] == "city":
                para = {
                    "receiverName": "张三",
                    "cellPhone": "12345678901",
                    "addressDetail": "南京大学",
                    "province": "浙江省",
                    "city": "南京市",
                    "area": "西湖区"
                }
            else:
                print("错误参数："+error[0])
        elif error.__len__() == 2:
            if error[0] == "city" and error[1] == "area":
                para = {
                    "receiverName": "张三",
                    "cellPhone": "12345678901",
                    "addressDetail": "南京大学",
                    "province": "江苏省",
                    "city": "杭州市",
                    "area": "西湖区"
                }
            else:
                print("错误参数：" + error[0]+"、"+error[1])
        elif error.__len__() == 3:
            if error[0] == "city" and error[1] == "area" and error[2] == "province":
                para = {
                    "receiverName": "张三",
                    "cellPhone": "12345678901",
                    "addressDetail": "南京大学",
                    "province": "安徽省",
                    "city": "南京市",
                    "area": "西湖区"
                }
            else:
                print("错误参数：" + error[0] + "、" + error[1]+"、"+error[2])
        else:
            print("参数过多")
        res = SendHttp().send_post_bycookie(url, self.user_login(),para)
        return res

    def exce_address(self):
        while (self.count() < 6):
            self.default_para()
        para = {
            "receiverName": "张三",
            "cellPhone": "12345678901",
            "addressDetail": "浙江大学",
            "province": "浙江省",
            "city": "浙江市",
            "area": "滨江区"
        }
        res = SendHttp().send_post_bycookie(url, self.user_login(),para)
        return res

    def logout_add(self):
        para = {
            "receiverName": "张三",
            "cellPhone": "12345678901",
            "addressDetail": "浙江大学",
            "province": "浙江省",
            "city": "浙江市",
            "area": "滨江区"
        }
        res = SendHttp().send_post(url, para)
        return res



