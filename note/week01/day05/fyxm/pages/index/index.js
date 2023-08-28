// pages/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    meetList:[
    {
      name:'1'
    },
    {
      name:'2'
    },    
    {
      name:'3'
    },

  ],
  list:[
    {
      title:'头部电商高并发秒杀系统',
      img:'/img/list.png'
    },
    {
      title:'头部电商高可用订单系统hahahahah',
      img:'/img/list.png'
    },
    {
      title:'头部电商高并发秒杀系统',
      img:'/img/list.png'
    },
    {
      title:'头部电商高可用订单系统',
      img:'/img/list.png'
    }
  ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

  },

  go(e) {
    wx.switchTab({
      url: '/'+e.currentTarget.dataset.go
    })
  },
})