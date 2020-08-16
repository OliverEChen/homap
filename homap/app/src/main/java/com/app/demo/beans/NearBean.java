package com.app.demo.beans;

import java.util.List;

/**
 * @anthor : 大海
 * 每天进步一点点
 * @time :   2020/3/31
 * @description :
 */


public class NearBean {


    /**
     * status : 0
     * msg : ok
     * result : [{"station":"西溪翠竹苑","lat":"30.287152","lng":"120.068796","distance":"149","lines":["860路(西溪竞舟苑-池华街公交站)","86路(景芳小区-西溪竞舟苑)"]},{"station":"西溪白荻苑","lat":"30.29045","lng":"120.068703","distance":"357","lines":["118路(西溪蒹葭苑-小车桥)","221路(西溪蒹葭苑-延安新村)"]}]
     */

    private String status;
    private String msg;
    private List<ResultBean> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * station : 西溪翠竹苑
         * lat : 30.287152
         * lng : 120.068796
         * distance : 149
         * lines : ["860路(西溪竞舟苑-池华街公交站)","86路(景芳小区-西溪竞舟苑)"]
         */

        private String station;
        private String lat;
        private String lng;
        private String distance;
        private List<String> lines;

        public String getStation() {
            return station;
        }

        public void setStation(String station) {
            this.station = station;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public List<String> getLines() {
            return lines;
        }

        public void setLines(List<String> lines) {
            this.lines = lines;
        }
    }
}
