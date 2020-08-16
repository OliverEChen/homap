package com.app.demo.beans;

import java.util.List;

/**
 * @anthor : 大海
 * 每天进步一点点
 * @time :   2020/6/17
 * @description :
 */


public class FindLine {


    /**
     * status : 0
     * msg : ok
     * result : [{"transitno":"976路","startstation":"大北窑南","endstation":"盛林苑公交场站","starttime":"06:40","endtime":"21:30","price":"2","maxprice":"9.00","buscompany":"北京公交集团第五客运分公司","timetable":"周一至周五 06:40-21:30周六日 06:40-21:30","updatetime":"2019-04-12","list":[{"sequenceno":1,"station":"大北窑南","lat":null,"lng":null,"subway":null}]},{"transitno":"976路","startstation":"盛林苑公交场站","endstation":"大北窑南","starttime":"05:00","endtime":"19:30","price":"2","maxprice":"9.00","buscompany":"北京公交集团第五客运分公司","timetable":"周一至周五 05:00-19:30  周六日 05:00-19:30","updatetime":"2018-12-13","list":[{"sequenceno":1,"station":"盛林苑公交场站","lat":null,"lng":null,"subway":null}]}]
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
         * transitno : 976路
         * startstation : 大北窑南
         * endstation : 盛林苑公交场站
         * starttime : 06:40
         * endtime : 21:30
         * price : 2
         * maxprice : 9.00
         * buscompany : 北京公交集团第五客运分公司
         * timetable : 周一至周五 06:40-21:30周六日 06:40-21:30
         * updatetime : 2019-04-12
         * list : [{"sequenceno":1,"station":"大北窑南","lat":null,"lng":null,"subway":null}]
         */

        private String transitno;
        private String startstation;
        private String endstation;
        private String starttime;
        private String endtime;
        private String price;
        private String maxprice;
        private String buscompany;
        private String timetable;
        private String updatetime;
        private List<ListBean> list;

        public String getTransitno() {
            return transitno;
        }

        public void setTransitno(String transitno) {
            this.transitno = transitno;
        }

        public String getStartstation() {
            return startstation;
        }

        public void setStartstation(String startstation) {
            this.startstation = startstation;
        }

        public String getEndstation() {
            return endstation;
        }

        public void setEndstation(String endstation) {
            this.endstation = endstation;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getMaxprice() {
            return maxprice;
        }

        public void setMaxprice(String maxprice) {
            this.maxprice = maxprice;
        }

        public String getBuscompany() {
            return buscompany;
        }

        public void setBuscompany(String buscompany) {
            this.buscompany = buscompany;
        }

        public String getTimetable() {
            return timetable;
        }

        public void setTimetable(String timetable) {
            this.timetable = timetable;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * sequenceno : 1
             * station : 大北窑南
             * lat : null
             * lng : null
             * subway : null
             */

            private int sequenceno;
            private String station;
            private Object lat;
            private Object lng;
            private Object subway;

            public int getSequenceno() {
                return sequenceno;
            }

            public void setSequenceno(int sequenceno) {
                this.sequenceno = sequenceno;
            }

            public String getStation() {
                return station;
            }

            public void setStation(String station) {
                this.station = station;
            }

            public Object getLat() {
                return lat;
            }

            public void setLat(Object lat) {
                this.lat = lat;
            }

            public Object getLng() {
                return lng;
            }

            public void setLng(Object lng) {
                this.lng = lng;
            }

            public Object getSubway() {
                return subway;
            }

            public void setSubway(Object subway) {
                this.subway = subway;
            }
        }
    }
}
