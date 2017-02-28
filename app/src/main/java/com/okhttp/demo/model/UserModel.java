package com.okhttp.demo.model;

import java.util.List;

/**
 * Created by hongmingwei on 2017/1/16 15:36
 */
public class UserModel {

    private MultiResultBean multiResult;

    public MultiResultBean getMultiResult() {
        return multiResult;
    }

    public void setMultiResult(MultiResultBean multiResult) {
        this.multiResult = multiResult;
    }

    public static class MultiResultBean {
        /**
         * location :
         * description : test
         * categories :
         * tags : test
         * itemId : 1000232
         * itemCode : yg8CVootoAc
         * title : test
         * picUrl : http://g1.tdimg.com/82091af066723b09f38ba175c47a407d/p_2.jpg
         * totalTime : 20100
         * channelId : 1
         * outerPlayerUrl : http://www.tudou.com/v/yg8CVootoAc/v.swf
         * itemUrl : http://www.tudou.com/programs/view/yg8CVootoAc/
         * alias :
         * definition : 0
         * mediaType : 视频
         * playTimes : 234762
         * downEnable : true
         * pubDate : 2006-04-27
         * favorall : 46
         * bigPicUrl : http://g1.tdimg.com/82091af066723b09f38ba175c47a407d/w_2.jpg
         * vcode :
         * hdType : 2
         * commentCount : 220
         * ownerId : 262809
         * ownerNickname : yumihhh
         * ownerURL : http://www.tudou.com/home/yumihhh
         * picUrl_16_9 : http://g1.tdimg.com/82091af066723b09f38ba175c47a407d/t_2.jpg
         * ownerName : yumihhh
         * picChoiceUrl : ["http://image2.tudou.com/data/imgs/i/001/000/232/m15.jpg","http://image2.tudou.com/data/imgs/i/001/000/232/m30.jpg"]
         * secret : false
         * addPlaylistTime :
         * ownerPic : http://u2.tdimg.com/u/000/262/809/p0.jpg
         * html5Url : http://www.tudou.com/programs/view/html5embed.action?code=yg8CVootoAc
         */

        private List<ResultsBean> results;

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            private String location;
            private String description;
            private String categories;
            private String tags;
            private int itemId;
            private String itemCode;
            private String title;
            private String picUrl;
            private int totalTime;
            private int channelId;
            private String outerPlayerUrl;
            private String itemUrl;
            private String alias;
            private int definition;
            private String mediaType;
            private int playTimes;
            private boolean downEnable;
            private String pubDate;
            private int favorall;
            private String bigPicUrl;
            private String vcode;
            private String hdType;
            private int commentCount;
            private int ownerId;
            private String ownerNickname;
            private String ownerURL;
            private String picUrl_16_9;
            private String ownerName;
            private boolean secret;
            private String addPlaylistTime;
            private String ownerPic;
            private String html5Url;
            private List<String> picChoiceUrl;

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCategories() {
                return categories;
            }

            public void setCategories(String categories) {
                this.categories = categories;
            }

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }

            public int getItemId() {
                return itemId;
            }

            public void setItemId(int itemId) {
                this.itemId = itemId;
            }

            public String getItemCode() {
                return itemCode;
            }

            public void setItemCode(String itemCode) {
                this.itemCode = itemCode;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public int getTotalTime() {
                return totalTime;
            }

            public void setTotalTime(int totalTime) {
                this.totalTime = totalTime;
            }

            public int getChannelId() {
                return channelId;
            }

            public void setChannelId(int channelId) {
                this.channelId = channelId;
            }

            public String getOuterPlayerUrl() {
                return outerPlayerUrl;
            }

            public void setOuterPlayerUrl(String outerPlayerUrl) {
                this.outerPlayerUrl = outerPlayerUrl;
            }

            public String getItemUrl() {
                return itemUrl;
            }

            public void setItemUrl(String itemUrl) {
                this.itemUrl = itemUrl;
            }

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public int getDefinition() {
                return definition;
            }

            public void setDefinition(int definition) {
                this.definition = definition;
            }

            public String getMediaType() {
                return mediaType;
            }

            public void setMediaType(String mediaType) {
                this.mediaType = mediaType;
            }

            public int getPlayTimes() {
                return playTimes;
            }

            public void setPlayTimes(int playTimes) {
                this.playTimes = playTimes;
            }

            public boolean isDownEnable() {
                return downEnable;
            }

            public void setDownEnable(boolean downEnable) {
                this.downEnable = downEnable;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public int getFavorall() {
                return favorall;
            }

            public void setFavorall(int favorall) {
                this.favorall = favorall;
            }

            public String getBigPicUrl() {
                return bigPicUrl;
            }

            public void setBigPicUrl(String bigPicUrl) {
                this.bigPicUrl = bigPicUrl;
            }

            public String getVcode() {
                return vcode;
            }

            public void setVcode(String vcode) {
                this.vcode = vcode;
            }

            public String getHdType() {
                return hdType;
            }

            public void setHdType(String hdType) {
                this.hdType = hdType;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public int getOwnerId() {
                return ownerId;
            }

            public void setOwnerId(int ownerId) {
                this.ownerId = ownerId;
            }

            public String getOwnerNickname() {
                return ownerNickname;
            }

            public void setOwnerNickname(String ownerNickname) {
                this.ownerNickname = ownerNickname;
            }

            public String getOwnerURL() {
                return ownerURL;
            }

            public void setOwnerURL(String ownerURL) {
                this.ownerURL = ownerURL;
            }

            public String getPicUrl_16_9() {
                return picUrl_16_9;
            }

            public void setPicUrl_16_9(String picUrl_16_9) {
                this.picUrl_16_9 = picUrl_16_9;
            }

            public String getOwnerName() {
                return ownerName;
            }

            public void setOwnerName(String ownerName) {
                this.ownerName = ownerName;
            }

            public boolean isSecret() {
                return secret;
            }

            public void setSecret(boolean secret) {
                this.secret = secret;
            }

            public String getAddPlaylistTime() {
                return addPlaylistTime;
            }

            public void setAddPlaylistTime(String addPlaylistTime) {
                this.addPlaylistTime = addPlaylistTime;
            }

            public String getOwnerPic() {
                return ownerPic;
            }

            public void setOwnerPic(String ownerPic) {
                this.ownerPic = ownerPic;
            }

            public String getHtml5Url() {
                return html5Url;
            }

            public void setHtml5Url(String html5Url) {
                this.html5Url = html5Url;
            }

            public List<String> getPicChoiceUrl() {
                return picChoiceUrl;
            }

            public void setPicChoiceUrl(List<String> picChoiceUrl) {
                this.picChoiceUrl = picChoiceUrl;
            }
        }
    }
}
