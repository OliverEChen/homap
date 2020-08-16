package com.app.demo.beans;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.List;

/**
 * @anthor : 大海
 * 每天进步一点点
 * @time :   2020/3/31
 * @description :
 */


public class LinesBean extends DataSupport implements Serializable {


    /**
     * status : 0
     * msg : ok
     * result : [{"totaldistance":"10.2公里","totalduration":"55分","totalprice":400,"arrivetime":"2020-04-01 12:17:54","tiptype":null,"totalstopnum":17,"totalwalkdistance":"302米","vehicles":["143路","91路"],"steps":[{"distance":6384,"duration":1134,"is_depot":0,"type":3,"vehicle":{"direct_text":"池华街公交站(下客点)方向","endname":"三坝站","endtime":"20:00","headway":"约15分钟/趟","is_rtbus":0,"kind_type":256,"line_color":"#f78731","name":"143路","startname":"西溪竞舟苑站","starttime":"05:50","stopnum":11,"price":0,"type":0,"working_time_desc":"","working_time_tag":"","zoneprice":0},"startpoi":{"lng":120.06460393398,"lat":30.288249914442},"endpoi":{"lng":120.10457852918,"lat":30.304573938621},"steptext":"从西溪竞舟苑站,乘143路(池华街公交站(下客点)方向),经过11站,到三坝站"},{"can_ride":0,"distance":1,"duration":0,"ename":"","type":5,"vehicle":[],"walk_type":1,"startpoi":{"lng":120.10457852918,"lat":30.304573938621},"endpoi":{"lng":120.10456954612,"lat":30.304573938621},"steptext":"同站换乘","endname":"三坝站"},{"distance":3527,"duration":723,"is_depot":0,"type":3,"vehicle":{"direct_text":"祥运路公交站方向","endname":"汽车北站(莫干山路)站","endtime":"21:20","headway":"约8分钟/趟","is_rtbus":0,"kind_type":256,"line_color":"#f78731","name":"91路","startname":"三坝站","starttime":"06:00","stopnum":6,"price":0,"type":0,"working_time_desc":"","working_time_tag":"","zoneprice":0},"startpoi":{"lng":120.10456954612,"lat":30.304573938621},"endpoi":{"lng":120.11914006149,"lat":30.322383793608},"steptext":"从三坝站,乘91路(祥运路公交站方向),经过6站,到汽车北站(莫干山路)站"},{"can_ride":0,"distance":301,"duration":258,"ename":"","type":5,"vehicle":[],"walk_type":1,"startpoi":{"lng":120.11914006149,"lat":30.322383793608},"endpoi":{"lng":120.11893345122,"lat":30.324238636443},"steptext":"步行301米","endname":null}]},{"totaldistance":"12.4公里","totalduration":"57分","totalprice":200,"arrivetime":"2020-04-01 12:20:35","tiptype":6,"totalstopnum":20,"totalwalkdistance":"1公里","vehicles":["148路"],"steps":[{"can_ride":1,"distance":816,"duration":699,"ename":"","type":5,"vehicle":[],"walk_type":1,"startpoi":{"lng":120.06456800176,"lat":30.287665192177},"endpoi":{"lng":120.06134308498,"lat":30.292311687935},"steptext":"步行816米","endname":"何家坝站"},{"distance":11327,"duration":1944,"is_depot":0,"type":3,"vehicle":{"direct_text":"汽车北站(下客点)方向","endname":"汽车北站(下客点)站","endtime":"21:00","headway":"约22分钟/趟","is_rtbus":0,"kind_type":256,"line_color":"#f78731","name":"148路","startname":"何家坝站","starttime":"06:15","stopnum":20,"price":0,"type":0,"working_time_desc":"","working_time_tag":"","zoneprice":0},"startpoi":{"lng":120.06134308498,"lat":30.292311687935},"endpoi":{"lng":120.12066718086,"lat":30.325321910596},"steptext":"从何家坝站,乘148路(汽车北站(下客点)方向),经过20站,到汽车北站(下客点)站"},{"can_ride":0,"distance":217,"duration":186,"ename":"","type":5,"vehicle":[],"walk_type":1,"startpoi":{"lng":120.12066718086,"lat":30.325321910596},"endpoi":{"lng":120.11893345122,"lat":30.324238636443},"steptext":"步行217米","endname":null}]},{"totaldistance":"10.2公里","totalduration":"55分","totalprice":400,"arrivetime":"2020-04-01 12:18:04","tiptype":null,"totalstopnum":17,"totalwalkdistance":"306米","vehicles":["143路","91路区间"],"steps":[{"distance":5460,"duration":913,"is_depot":0,"type":3,"vehicle":{"direct_text":"池华街公交站(下客点)方向","endname":"政新花园站","endtime":"20:00","headway":"约15分钟/趟","is_rtbus":0,"kind_type":256,"line_color":"#f78731","name":"143路","startname":"西溪竞舟苑站","starttime":"05:50","stopnum":9,"price":0,"type":0,"working_time_desc":"","working_time_tag":"","zoneprice":0},"startpoi":{"lng":120.06460393398,"lat":30.288249914442},"endpoi":{"lng":120.10456056306,"lat":30.296264152771},"steptext":"从西溪竞舟苑站,乘143路(池华街公交站(下客点)方向),经过9站,到政新花园站"},{"can_ride":0,"distance":2,"duration":1,"ename":"","type":5,"vehicle":[],"walk_type":0,"startpoi":{"lng":120.10456056306,"lat":30.296264152771},"endpoi":{"lng":120.10457852918,"lat":30.2962719484},"steptext":"同站换乘","endname":"政新花园站"},{"distance":4444,"duration":951,"is_depot":0,"type":3,"vehicle":{"direct_text":"祥运路公交站方向","endname":"汽车北站(莫干山路)站","endtime":"22:00","headway":"约22分钟/趟","is_rtbus":0,"kind_type":256,"line_color":"#f78731","name":"91路区间","startname":"政新花园站","starttime":"06:10","stopnum":8,"price":0,"type":0,"working_time_desc":"","working_time_tag":"","zoneprice":0},"startpoi":{"lng":120.10457852918,"lat":30.2962719484},"endpoi":{"lng":120.11917599371,"lat":30.322368206543},"steptext":"从政新花园站,乘91路区间(祥运路公交站方向),经过8站,到汽车北站(莫干山路)站"},{"can_ride":0,"distance":304,"duration":260,"ename":"","type":5,"vehicle":[],"walk_type":1,"startpoi":{"lng":120.11917599371,"lat":30.322368206543},"endpoi":{"lng":120.11893345122,"lat":30.324238636443},"steptext":"步行304米","endname":null}]},{"totaldistance":"10.9公里","totalduration":"59分","totalprice":800,"arrivetime":"2020-04-01 12:23:27","tiptype":null,"totalstopnum":12,"totalwalkdistance":"807米","vehicles":["333路","地铁5号线","313路"],"steps":[{"distance":3243,"duration":624,"is_depot":0,"type":3,"vehicle":{"direct_text":"西湖科技园方向","endname":"地铁蒋村站","endtime":"19:00","headway":"约22分钟/趟","is_rtbus":0,"kind_type":2,"line_color":"#f78731","name":"333路","startname":"西溪竞舟苑站","starttime":"06:50","stopnum":6,"time_table":["06:50-19:00"],"price":0,"type":0,"working_time_desc":"工作日运营","working_time_tag":"工作日车","zoneprice":0},"startpoi":{"lng":120.06458596787,"lat":30.288249914442},"endpoi":{"lng":120.07524885427,"lat":30.300364567529},"steptext":"从西溪竞舟苑站,乘333路(西湖科技园方向),经过6站,到地铁蒋村站"},{"can_ride":0,"distance":114,"duration":95,"ename":" D1入口","swalk_end_leadpoint":[13366796,3520424],"type":5,"vehicle":[],"walk_type":1,"startpoi":{"lng":120.07524885427,"lat":30.300364567529},"endpoi":{"lng":120.0746829218,"lat":30.300504882839},"steptext":"步行114米","endname":"蒋村站(D1口)"},{"distance":5626,"duration":720,"is_depot":0,"type":3,"vehicle":{"alias_name":"5号线","direct_text":"善贤方向","endname":"和睦站","endtime":"22:41","is_rtbus":0,"kind_type":512,"line_color":"#69c1bd","name":"地铁5号线","startname":"蒋村站(D1口)","starttime":"06:03","stopnum":4,"price":0,"type":1,"working_time_desc":"","working_time_tag":"","zoneprice":0},"startpoi":{"lng":120.0746829218,"lat":30.300504882839},"endpoi":{"lng":120.12637142085,"lat":30.315517449042},"steptext":"从蒋村站(D1口),乘地铁5号线(善贤方向),经过4站,到和睦站(E1口)"},{"can_ride":0,"distance":392,"duration":331,"ename":"","type":5,"vehicle":[],"walk_type":1,"startpoi":{"lng":120.12637142085,"lat":30.315517449042},"endpoi":{"lng":120.12570667477,"lat":30.314730243411},"steptext":"步行392米","endname":"地铁和睦站西站"},{"distance":1244,"duration":221,"is_depot":0,"type":3,"vehicle":{"direct_text":"瓶窑南站方向","endname":"汽车北站(莫干山路)站","endtime":"21:00","headway":"约22分钟/趟","is_rtbus":0,"kind_type":256,"line_color":"#f78731","name":"313路","startname":"地铁和睦站西站","starttime":"05:10","stopnum":2,"price":0,"type":0,"working_time_desc":"","working_time_tag":"","zoneprice":0},"startpoi":{"lng":120.12570667477,"lat":30.314730243411},"endpoi":{"lng":120.11914904455,"lat":30.32239158714},"steptext":"从地铁和睦站西站,乘313路(瓶窑南站方向),经过2站,到汽车北站(莫干山路)站"},{"can_ride":0,"distance":301,"duration":258,"ename":"","type":5,"vehicle":[],"walk_type":1,"startpoi":{"lng":120.11914904455,"lat":30.32239158714},"endpoi":{"lng":120.11893345122,"lat":30.324238636443},"steptext":"步行301米","endname":null}]},{"totaldistance":"10公里","totalduration":"1时5分","totalprice":800,"arrivetime":"2020-04-01 12:29:00","tiptype":null,"totalstopnum":8,"totalwalkdistance":"1.8公里","vehicles":["118路","地铁5号线","313路"],"steps":[{"distance":2212,"duration":419,"is_depot":0,"type":3,"vehicle":{"direct_text":"六公园方向","endname":"合建村站","endtime":"20:00","headway":"约15分钟/趟","is_rtbus":0,"kind_type":256,"line_color":"#f78731","name":"118路","startname":"西溪竞舟苑站","starttime":"05:50","stopnum":3,"price":0,"type":0,"working_time_desc":"","working_time_tag":"","zoneprice":0},"startpoi":{"lng":120.06456800176,"lat":30.287634006891},"endpoi":{"lng":120.08203106087,"lat":30.292475402691},"steptext":"从西溪竞舟苑站,乘118路(六公园方向)或143路,经过3站,到合建村站"},{"can_ride":1,"distance":1142,"duration":974,"ename":" C2入口","swalk_end_leadpoint":[13367879,3520375],"type":5,"vehicle":[],"walk_type":1,"startpoi":{"lng":120.08203106087,"lat":30.292475402691},"endpoi":{"lng":120.08376479051,"lat":30.299865667003},"steptext":"步行1.1公里","endname":"浙大紫金港站(C2口)"},{"distance":4748,"duration":540,"is_depot":0,"type":3,"vehicle":{"alias_name":"5号线","direct_text":"善贤方向","endname":"和睦站","endtime":"22:43","is_rtbus":0,"kind_type":512,"line_color":"#69c1bd","name":"地铁5号线","startname":"浙大紫金港站(C2口)","starttime":"06:06","stopnum":3,"price":0,"type":1,"working_time_desc":"","working_time_tag":"","zoneprice":0},"startpoi":{"lng":120.08376479051,"lat":30.299865667003},"endpoi":{"lng":120.12637142085,"lat":30.315517449042},"steptext":"从浙大紫金港站(C2口),乘地铁5号线(善贤方向),经过3站,到和睦站(E1口)"},{"can_ride":0,"distance":392,"duration":331,"ename":"","type":5,"vehicle":[],"walk_type":1,"startpoi":{"lng":120.12637142085,"lat":30.315517449042},"endpoi":{"lng":120.12570667477,"lat":30.314730243411},"steptext":"步行392米","endname":"地铁和睦站西站"},{"distance":1244,"duration":221,"is_depot":0,"type":3,"vehicle":{"direct_text":"瓶窑南站方向","endname":"汽车北站(莫干山路)站","endtime":"21:00","headway":"约22分钟/趟","is_rtbus":0,"kind_type":256,"line_color":"#f78731","name":"313路","startname":"地铁和睦站西站","starttime":"05:10","stopnum":2,"price":0,"type":0,"working_time_desc":"","working_time_tag":"","zoneprice":0},"startpoi":{"lng":120.12570667477,"lat":30.314730243411},"endpoi":{"lng":120.11914904455,"lat":30.32239158714},"steptext":"从地铁和睦站西站,乘313路(瓶窑南站方向),经过2站,到汽车北站(莫干山路)站"},{"can_ride":0,"distance":301,"duration":258,"ename":"","type":5,"vehicle":[],"walk_type":1,"startpoi":{"lng":120.11914904455,"lat":30.32239158714},"endpoi":{"lng":120.11893345122,"lat":30.324238636443},"steptext":"步行301米","endname":null}]}]
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
         * totaldistance : 10.2公里
         * totalduration : 55分
         * totalprice : 400
         * arrivetime : 2020-04-01 12:17:54
         * tiptype : null
         * totalstopnum : 17
         * totalwalkdistance : 302米
         * vehicles : ["143路","91路"]
         * steps : [{"distance":6384,"duration":1134,"is_depot":0,"type":3,"vehicle":{"direct_text":"池华街公交站(下客点)方向","endname":"三坝站","endtime":"20:00","headway":"约15分钟/趟","is_rtbus":0,"kind_type":256,"line_color":"#f78731","name":"143路","startname":"西溪竞舟苑站","starttime":"05:50","stopnum":11,"price":0,"type":0,"working_time_desc":"","working_time_tag":"","zoneprice":0},"startpoi":{"lng":120.06460393398,"lat":30.288249914442},"endpoi":{"lng":120.10457852918,"lat":30.304573938621},"steptext":"从西溪竞舟苑站,乘143路(池华街公交站(下客点)方向),经过11站,到三坝站"},{"can_ride":0,"distance":1,"duration":0,"ename":"","type":5,"vehicle":[],"walk_type":1,"startpoi":{"lng":120.10457852918,"lat":30.304573938621},"endpoi":{"lng":120.10456954612,"lat":30.304573938621},"steptext":"同站换乘","endname":"三坝站"},{"distance":3527,"duration":723,"is_depot":0,"type":3,"vehicle":{"direct_text":"祥运路公交站方向","endname":"汽车北站(莫干山路)站","endtime":"21:20","headway":"约8分钟/趟","is_rtbus":0,"kind_type":256,"line_color":"#f78731","name":"91路","startname":"三坝站","starttime":"06:00","stopnum":6,"price":0,"type":0,"working_time_desc":"","working_time_tag":"","zoneprice":0},"startpoi":{"lng":120.10456954612,"lat":30.304573938621},"endpoi":{"lng":120.11914006149,"lat":30.322383793608},"steptext":"从三坝站,乘91路(祥运路公交站方向),经过6站,到汽车北站(莫干山路)站"},{"can_ride":0,"distance":301,"duration":258,"ename":"","type":5,"vehicle":[],"walk_type":1,"startpoi":{"lng":120.11914006149,"lat":30.322383793608},"endpoi":{"lng":120.11893345122,"lat":30.324238636443},"steptext":"步行301米","endname":null}]
         */

        private String totaldistance;
        private String totalduration;
        private int totalprice;
        private String arrivetime;
        private String tiptype;
        private int totalstopnum;
        private String totalwalkdistance;
        private List<String> vehicles;
        private List<StepsBean> steps;

        public String getTotaldistance() {
            return totaldistance;
        }

        public void setTotaldistance(String totaldistance) {
            this.totaldistance = totaldistance;
        }

        public String getTotalduration() {
            return totalduration;
        }

        public void setTotalduration(String totalduration) {
            this.totalduration = totalduration;
        }

        public int getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(int totalprice) {
            this.totalprice = totalprice;
        }

        public String getArrivetime() {
            return arrivetime;
        }

        public void setArrivetime(String arrivetime) {
            this.arrivetime = arrivetime;
        }

        public String getTiptype() {
            return tiptype;
        }

        public void setTiptype(String tiptype) {
            this.tiptype = tiptype;
        }

        public int getTotalstopnum() {
            return totalstopnum;
        }

        public void setTotalstopnum(int totalstopnum) {
            this.totalstopnum = totalstopnum;
        }

        public String getTotalwalkdistance() {
            return totalwalkdistance;
        }

        public void setTotalwalkdistance(String totalwalkdistance) {
            this.totalwalkdistance = totalwalkdistance;
        }

        public List<String> getVehicles() {
            return vehicles;
        }

        public void setVehicles(List<String> vehicles) {
            this.vehicles = vehicles;
        }

        public List<StepsBean> getSteps() {
            return steps;
        }

        public void setSteps(List<StepsBean> steps) {
            this.steps = steps;
        }

        public static class StepsBean {
            /**
             * distance : 6384
             * duration : 1134
             * is_depot : 0
             * type : 3
             * vehicle : {"direct_text":"池华街公交站(下客点)方向","endname":"三坝站","endtime":"20:00","headway":"约15分钟/趟","is_rtbus":0,"kind_type":256,"line_color":"#f78731","name":"143路","startname":"西溪竞舟苑站","starttime":"05:50","stopnum":11,"price":0,"type":0,"working_time_desc":"","working_time_tag":"","zoneprice":0}
             * startpoi : {"lng":120.06460393398,"lat":30.288249914442}
             * endpoi : {"lng":120.10457852918,"lat":30.304573938621}
             * steptext : 从西溪竞舟苑站,乘143路(池华街公交站(下客点)方向),经过11站,到三坝站
             * can_ride : 0
             * ename :
             * walk_type : 1
             * endname : 三坝站
             */

            private int distance;
            private int duration;
            private int is_depot;
            private int type;
//            private VehicleBean vehicle;
//            private StartpoiBean startpoi;
//            private EndpoiBean endpoi;
            private String steptext;
            private int can_ride;
            private String ename;
            private int walk_type;
            private String endname;

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getIs_depot() {
                return is_depot;
            }

            public void setIs_depot(int is_depot) {
                this.is_depot = is_depot;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

//            public VehicleBean getVehicle() {
//                return vehicle;
//            }
//
//            public void setVehicle(VehicleBean vehicle) {
//                this.vehicle = vehicle;
//            }
//
//            public StartpoiBean getStartpoi() {
//                return startpoi;
//            }
//
//            public void setStartpoi(StartpoiBean startpoi) {
//                this.startpoi = startpoi;
//            }
//
//            public EndpoiBean getEndpoi() {
//                return endpoi;
//            }
//
//            public void setEndpoi(EndpoiBean endpoi) {
//                this.endpoi = endpoi;
//            }

            public String getSteptext() {
                return steptext;
            }

            public void setSteptext(String steptext) {
                this.steptext = steptext;
            }

            public int getCan_ride() {
                return can_ride;
            }

            public void setCan_ride(int can_ride) {
                this.can_ride = can_ride;
            }

            public String getEname() {
                return ename;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public int getWalk_type() {
                return walk_type;
            }

            public void setWalk_type(int walk_type) {
                this.walk_type = walk_type;
            }

            public String getEndname() {
                return endname;
            }

            public void setEndname(String endname) {
                this.endname = endname;
            }

            public static class VehicleBean {
                /**
                 * direct_text : 池华街公交站(下客点)方向
                 * endname : 三坝站
                 * endtime : 20:00
                 * headway : 约15分钟/趟
                 * is_rtbus : 0
                 * kind_type : 256
                 * line_color : #f78731
                 * name : 143路
                 * startname : 西溪竞舟苑站
                 * starttime : 05:50
                 * stopnum : 11
                 * price : 0
                 * type : 0
                 * working_time_desc :
                 * working_time_tag :
                 * zoneprice : 0
                 */

                private String direct_text;
                private String endname;
                private String endtime;
                private String headway;
                private int is_rtbus;
                private int kind_type;
                private String line_color;
                private String name;
                private String startname;
                private String starttime;
                private int stopnum;
                private int price;
                private int type;
                private String working_time_desc;
                private String working_time_tag;
                private int zoneprice;

                public String getDirect_text() {
                    return direct_text;
                }

                public void setDirect_text(String direct_text) {
                    this.direct_text = direct_text;
                }

                public String getEndname() {
                    return endname;
                }

                public void setEndname(String endname) {
                    this.endname = endname;
                }

                public String getEndtime() {
                    return endtime;
                }

                public void setEndtime(String endtime) {
                    this.endtime = endtime;
                }

                public String getHeadway() {
                    return headway;
                }

                public void setHeadway(String headway) {
                    this.headway = headway;
                }

                public int getIs_rtbus() {
                    return is_rtbus;
                }

                public void setIs_rtbus(int is_rtbus) {
                    this.is_rtbus = is_rtbus;
                }

                public int getKind_type() {
                    return kind_type;
                }

                public void setKind_type(int kind_type) {
                    this.kind_type = kind_type;
                }

                public String getLine_color() {
                    return line_color;
                }

                public void setLine_color(String line_color) {
                    this.line_color = line_color;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getStartname() {
                    return startname;
                }

                public void setStartname(String startname) {
                    this.startname = startname;
                }

                public String getStarttime() {
                    return starttime;
                }

                public void setStarttime(String starttime) {
                    this.starttime = starttime;
                }

                public int getStopnum() {
                    return stopnum;
                }

                public void setStopnum(int stopnum) {
                    this.stopnum = stopnum;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getWorking_time_desc() {
                    return working_time_desc;
                }

                public void setWorking_time_desc(String working_time_desc) {
                    this.working_time_desc = working_time_desc;
                }

                public String getWorking_time_tag() {
                    return working_time_tag;
                }

                public void setWorking_time_tag(String working_time_tag) {
                    this.working_time_tag = working_time_tag;
                }

                public int getZoneprice() {
                    return zoneprice;
                }

                public void setZoneprice(int zoneprice) {
                    this.zoneprice = zoneprice;
                }
            }

            public static class StartpoiBean {
                /**
                 * lng : 120.06460393398
                 * lat : 30.288249914442
                 */

                private double lng;
                private double lat;

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }
            }

            public static class EndpoiBean {
                /**
                 * lng : 120.10457852918
                 * lat : 30.304573938621
                 */

                private double lng;
                private double lat;

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }
            }
        }
    }
}
