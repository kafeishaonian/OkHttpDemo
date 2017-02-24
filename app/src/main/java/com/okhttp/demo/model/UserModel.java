package com.okhttp.demo.model;

import java.util.List;

/**
 * Created by hongmingwei on 2017/1/16 15:36
 */
public class UserModel extends AbstractBaseModel {


    private ItemBean item;

    public ItemBean getItem() {
        return item;
    }

    public void setItem(ItemBean item) {
        this.item = item;
    }

    public static class ItemBean {
        private int isTradeTime;
        private Object homepagePrompt;

        private NonfarmInfoMapBean nonfarmInfoMap;

        private List<ProfitShowListBean> profitShowList;

        public int getIsTradeTime() {
            return isTradeTime;
        }

        public void setIsTradeTime(int isTradeTime) {
            this.isTradeTime = isTradeTime;
        }

        public Object getHomepagePrompt() {
            return homepagePrompt;
        }

        public void setHomepagePrompt(Object homepagePrompt) {
            this.homepagePrompt = homepagePrompt;
        }

        public NonfarmInfoMapBean getNonfarmInfoMap() {
            return nonfarmInfoMap;
        }

        public void setNonfarmInfoMap(NonfarmInfoMapBean nonfarmInfoMap) {
            this.nonfarmInfoMap = nonfarmInfoMap;
        }

        public List<ProfitShowListBean> getProfitShowList() {
            return profitShowList;
        }

        public void setProfitShowList(List<ProfitShowListBean> profitShowList) {
            this.profitShowList = profitShowList;
        }

        public static class NonfarmInfoMapBean {
            private String text;
            private int flag;
            private String nonfarm_Url;
            private int left_time;
            private String notice;
            private int validTime;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getFlag() {
                return flag;
            }

            public void setFlag(int flag) {
                this.flag = flag;
            }

            public String getNonfarm_Url() {
                return nonfarm_Url;
            }

            public void setNonfarm_Url(String nonfarm_Url) {
                this.nonfarm_Url = nonfarm_Url;
            }

            public int getLeft_time() {
                return left_time;
            }

            public void setLeft_time(int left_time) {
                this.left_time = left_time;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }

            public int getValidTime() {
                return validTime;
            }

            public void setValidTime(int validTime) {
                this.validTime = validTime;
            }
        }

        public static class ProfitShowListBean {
            private int id;
            private String phone;
            private double profit;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public double getProfit() {
                return profit;
            }

            public void setProfit(double profit) {
                this.profit = profit;
            }
        }
    }
}
