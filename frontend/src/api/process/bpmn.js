import request from '@/plugin/axios'

export function getTest (data) {
  return request({
    url: '/api/getMap',
    method: 'get',
    data
  })
}

export function getDataNum (data) {
  return request({
    url: '/api/index/getDataNum',
    method: 'get',
    data
  })
}

export function processDefinition (data) {
  return request({
    url: '/rest/process-definition',
    method: 'get',
    data
  })
}
