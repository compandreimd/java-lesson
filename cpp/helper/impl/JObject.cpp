//
// Created by compandreimd on 16.07.2024.
//

#include <version>
#include "JObject.hpp"

namespace java {
    namespace lang {
        int JObject::_count = 0;
        JObject** JObject::_objs = nullptr;
        JObject::JObject() {
            this->_hashCode = (jlong) this;

            if (_count == 0){
                _objs = new JObject*[_count++];
                _objs[0] = this;
            } else {
                JObject** old = _objs;
                _objs = new JObject*[_count++];
                for(jint i = 0; i < _count - 1; i++)
                    _objs[i] = old[i];
                _objs[_count - 1] = this;
                delete[] old;
            }
        }
        JObject::~JObject() {}
        jboolean JObject::equals(JObject obj) {
            return &obj == this;
        }
        jint JObject::hashCode() {
            return _hashCode;
        }
    }
}