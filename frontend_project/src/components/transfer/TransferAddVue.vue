<template>
  <div class="content-container2 add-transfer">
    <header>
      <div class="header-content">방 내놓기</div>
    </header>

    <div class="detail-contents">
      <h1>기본 정보</h1>
      <table>
        <colgroup>
          <col width="150px" />
          <col />
        </colgroup>
        <tbody>
          <tr>
            <th>매물 종류</th>
            <td>
              <div class="input-wrap">
                <ul class="radio-list">
                  <li>
                    <label class="input-radio">
                      <input
                        type="radio"
                        name="roomType"
                        value="원룸"
                        v-model="roomType"
                      />
                      <p>원룸</p>
                    </label>
                  </li>
                  <li>
                    <label class="input-radio">
                      <input
                        type="radio"
                        name="roomType"
                        value="투룸"
                        v-model="roomType"
                      />
                      <p>투룸</p>
                    </label>
                  </li>

                  <li>
                    <label class="input-radio">
                      <input
                        type="radio"
                        name="roomType"
                        value="쓰리룸"
                        v-model="roomType"
                      />
                      <p>쓰리룸</p>
                    </label>
                  </li>

                  <li>
                    <label class="input-radio">
                      <input
                        type="radio"
                        name="roomType"
                        value="아파트"
                        v-model="roomType"
                      />
                      <p>아파트</p>
                    </label>
                  </li>

                  <li>
                    <label class="input-radio">
                      <input
                        type="radio"
                        name="roomType"
                        value="오피스텔"
                        v-model="roomType"
                      />
                      <p>오피스텔</p>
                    </label>
                  </li>
                </ul>
              </div>
            </td>
          </tr>

          <tr>
            <th>계약 종류</th>
            <td>
              <div class="input-wrap">
                <ul class="radio-list">
                  <li>
                    <label class="input-radio">
                      <input
                        type="radio"
                        name="contractType"
                        value="월세"
                        v-model="contractType"
                      />
                      <p>월세</p>
                    </label>
                  </li>

                  <li>
                    <label class="input-radio">
                      <input
                        type="radio"
                        name="contractType"
                        value="전세"
                        v-model="contractType"
                      />
                      <p>전세</p>
                    </label>
                  </li>
                </ul>
              </div>
            </td>
          </tr>

          <tr>
            <th rowspan="2">주소</th>
            <td>
              <div class="input-wrap">
                <div id="deal-input">
                  <!-- <div class="row col-md-12 justify-content-center mb-2"> -->

                  <div class="form-group col-md-2">
                    <select
                      class="form-select"
                      id="sido"
                      v-model="sidoCode"
                      @change="gugunList($event)"
                    >
                      <option
                        v-for="(item, index) in sidos"
                        :value="item.value"
                        :key="index"
                      >
                        {{ item.text }}
                      </option>
                    </select>
                  </div>
                  <div class="form-group col-md-2">
                    <select
                      class="form-select"
                      id="gugun"
                      v-model="gugunCode"
                      @change="dongList"
                    >
                      <option
                        v-for="(item, index) in guguns"
                        :value="item.value"
                        :key="index"
                      >
                        {{ item.text }}
                      </option>
                    </select>
                  </div>
                  <div class="form-group col-md-2">
                    <select
                      class="form-select"
                      id="dong"
                      v-model="dongCode"
                      @change="getDongName"
                    >
                      <option
                        v-for="(item, index) in dongs"
                        :value="item.value"
                        :key="index"
                      >
                        {{ item.text }}
                      </option>
                    </select>
                  </div>
                  <!-- </div> -->
                </div>
              </div>
            </td>
          </tr>
          <tr>
            <td>
              <div class="input-wrap">
                <input
                  type="text"
                  name="roomAddress"
                  class="detail-input"
                  v-model="roomAddress"
                  placeholder="예) 대전광역시 유성구 온천1동 124 삼성화재 유성연수원 "
                />
                <div class="address__btn">
                  <span><button @click="insertFormData" style = "font-size:15px">확인</button></span>
                </div>
              </div>
            </td>
          </tr>

          <tr>
            <th>층</th>
            <td>
              <div class="input-wrap">
                <input
                  type="number"
                  name="roomFloor"
                  class="detail-input"
                  v-model="roomFloor"
                  placeholder="예) 4"
                />
              </div>
            </td>
          </tr>

          <tr>
            <th>계약 종료일</th>
            <td>
              <div class="input-wrap">
                <input
                  type="date"
                  name="contractEndTime"
                  class="detail-input"
                  v-model="contractEndDay"
                />
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="detail-contents">
      <h1>상세 설명</h1>
      <table>
        <colgroup>
          <col width="150px" />
          <col />
        </colgroup>
        <tbody>
          <tr>
            <th>제목</th>
            <td>
              <div class="input-wrap">
                <input
                  class="detail-input"
                  name="tbTitle"
                  type="text"
                  placeholder="예) 충남대 도보 10분거리, 혼자 살기 좋은 방 양도합니다."
                  v-model="title"
                />
              </div>
            </td>
          </tr>
          <tr>
            <th>상세 설명</th>
            <td>
              <div class="input-wrap">
                <textarea
                  class="detail-text-area"
                  name="tbContent"
                  placeholder="양도 상세설명 작성"
                  v-model="content"
                ></textarea>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="room-deal-information-container">
      <div class="room-deal-information-title">사진 등록</div>
      <div class="room-picture-notice">
        <ul class="room-write-wrapper">
          <li>
            사진은 가로로 찍은 사진을 권장합니다. (가로 사이즈 최소 800px)
          </li>
          <li>사진 용량은 사진 한 장당 10MB 까지 등록이 가능합니다.</li>
        </ul>
      </div>
      <div class="room-file-upload-wrapper">
        <div v-if="!files.length" class="room-file-upload-example-container">
          <div class="room-file-upload-example">
            <div class="room-file-image-example-wrapper">이미지</div>
            <div class="room-file-notice-item">
              실사진 최소 3장 이상 등록하셔야 하며, 가로사진을 권장합니다.
            </div>
            <div class="room-file-notice-item room-file-notice-item-red">
              로고를 제외한 불필요한 정보(워터마크,상호,전화번호 등)가 있는
              매물은 비공개처리됩니다
            </div>
            <div class="room-file-notice-item room-file-upload-button">
              <div class="image-box">
                <!-- <div class="image-profile"><img :src="profileImage"/></div>-->
                <label for="file">일반 사진 등록</label>
                <input
                  type="file"
                  id="file"
                  ref="files"
                  @change="imageUpload"
                  multiple
                />
              </div>
            </div>
          </div>
        </div>
        <div v-else class="file-preview-content-container">
          <div class="file-preview-container">
            <div
              v-for="(file, index) in files"
              :key="index"
              class="file-preview-wrapper"
            >
              <div
                class="file-close-button"
                @click="fileDeleteButton"
                :name="file.number"
              >
                x
              </div>
              <img :src="file.preview" />
            </div>
            <div class="file-preview-wrapper-upload">
              <div class="image-box">
                <label for="file">추가 사진 등록</label>
                <input
                  type="file"
                  id="file"
                  ref="files"
                  @change="imageAddUpload"
                  multiple
                />
              </div>
              <!-- <div class="file-close-button" @click="fileDeleteButton" :name="file.number">x</div> -->
            </div>
          </div>
        </div>
      </div>
    </div>


      <div id="inspire">
        <div id="input-usage">
          <div>
            <div row wrap>
              <div xs12>
                <div class="dropzone" id="dropzone" ref="dropzone">
                  <div class="text-container">
                    <span @click="clickHandler">{{ text }}</span>
                    <input ref="fileInput" v-show="false" type="file"/>
                  </div>    
                </div>
              </div>
              <div xs12>
                <div row>
                  <div></div>
                </div>
              </div>
              <div xs12 style="text-align: center;">
                <span>{{ attachments.length }} files</span>
                <span>{{ message }}</span>
              </div>
            </div>
          </div>
        </div>
      </div>

    <div class="agree-wrap">
      <label class="check-label">
        <input type="checkbox" />
        <p>입력한 정보는 실제 매물과 다름이 없습니다.</p>
      </label>

      <div class="btn-wrap">
        <button class="cancel" @click="cancelBtn">취소</button>
        <button class="add" @click="registBtn">매물등록</button>
      </div>
    </div>
  </div>
</template>

<script>
import { setTransferBoard } from "@/api/transferBoard";
import { mapState, mapActions } from "vuex";

const regionStore = "regionStore";

let testLat = null;
let testLng = null;

export default {
  name: "TransferAddVue",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dongCode: null,

      sidoName: null,
      gugunName: null,
      dongName: null,

      //매물 종류
      roomType: null,
      contractType: null,
      roomAddress: null,
      roomFloor: null,
      contractEndDay: null,
      title: null,
      content: null,
      roomLat: null,
      roomLng: null,

      files: [], //업로드용 파일
      filesPreview: [],
      uploadImageIndex: 0,
      text: '임대인이 양도에 동의했음을 증명할 수 있는 파일을 업로드해주세요.',
      attachments: [],
      message: '',
      files2: [],
    };
  },
  created: function () {
    //시도구군 정보 초기화
    this.clearInfo();

    //시도 정보 불러오기
    this.getSido();
  },
  mounted: function () {
    // if (!window.kakao || !window.kakao.maps) {
    const script = document.createElement("script");
    script.src =
      "//dapi.kakao.com/v2/maps/sdk.js?appkey=60929dd5ec29490e1dec592ba22a0dff&autoload=false&libraries=services";
    script.addEventListener("load", () => {
      kakao.maps.load(this.initMap);
    });
    document.head.appendChild(script);
    // }

    const events = ['drag', 'dragstart', 'dragend', 'dragover', 'dragenter', 'dragleave', 'drop']
    events.forEach( function( evt ) {
      this.$refs.dropzone.addEventListener(evt, function(e){ 
        e.preventDefault();
        e.stopPropagation();
      }.bind(this), false);
    }.bind(this));
    
    this.$refs.dropzone.addEventListener('drop', function(e){
      for( let i = 0; i < e.dataTransfer.files.length; i++ ){
        console.log(e.dataTransfer)
        this.attachments.push( e.dataTransfer.files[i] );
      }
    }.bind(this));
  },
  computed: {
    ...mapState(regionStore, ["sidos", "guguns", "dongs"]),
  },
  methods: {
    ...mapActions(regionStore, [
      "getSido",
      "getGugun",
      "getDong",
      "clearInfo",
      "clearGugun",
      "clearDong",
    ]),
    initMap() {
      console.log("map test");
    },
    gugunList: async function () {
      this.clearGugun(); //기존에 있던 동 정보 삭제.
      this.gugunCode = null;
      if (this.sidoCode) await this.getGugun(this.sidoCode);
    },
    dongList: async function () {
      this.clearDong();
      this.dongCode = null;
      if (this.gugunCode) await this.getDong(this.gugunCode);
    },
    getDongName: function () {
      console.log(this.sidoName);
      console.log(this.gugunName);
      console.log(this.dongName);
    },
    getAddressName: function () {
      //선택한 시도 이름
      let sidoDoc = document.querySelector("#sido");
      this.sidoName = sidoDoc.options[sidoDoc.selectedIndex].textContent;

      //선택한 구군 이름
      let gugunDoc = document.querySelector("#gugun");
      this.gugunName = gugunDoc.options[gugunDoc.selectedIndex].textContent;
      //선택한 동 이름.
      let dongDoc = document.querySelector("#dong");
      this.dongName = dongDoc.options[dongDoc.selectedIndex].textContent;
    },
    imageUpload() {
      console.log(this.$refs.files.files);
      // this.files = [...this.files, this.$refs.files.files];
      //하나의 배열로 넣기
      let num = -1;
      for (let i = 0; i < this.$refs.files.files.length; i++) {
        console.log("test" + this.$refs.files.files[i]);
        this.files2.push(this.$refs.files.files[i]);
        this.files = [
          ...this.files,
          //이미지 업로드
          {
            //실제 파일
            file: this.$refs.files.files[i],
            //이미지 프리뷰
            preview: URL.createObjectURL(this.$refs.files.files[i]),
            //삭제및 관리를 위한 number
            number: i,
          },
        ];
        num = i;
        //이미지 업로드용 프리뷰
        // this.filesPreview = [
        //   ...this.filesPreview,
        //   { file: URL.createObjectURL(this.$refs.files.files[i]), number: i }
        // ];
      }
      this.uploadImageIndex = num + 1; //이미지 index의 마지막 값 + 1 저장
      console.log(this.files);
      // console.log(this.filesPreview);
    },
    imageAddUpload() {
      console.log(this.$refs.files.files);
      // this.files = [...this.files, this.$refs.files.files];
      //하나의 배열로 넣기c
      let num = -1;
      for (let i = 0; i < this.$refs.files.files.length; i++) {
        console.log(this.uploadImageIndex);
        this.files2.push(this.$refs.files.files[i]);
        this.files = [
          ...this.files,
          //이미지 업로드
          {
            //실제 파일
            file: this.$refs.files.files[i],
            //이미지 프리뷰
            preview: URL.createObjectURL(this.$refs.files.files[i]),
            //삭제및 관리를 위한 number
            number: i + this.uploadImageIndex,
          },
        ];
        num = i;
      }
      console.log("file check");

      this.uploadImageIndex = this.uploadImageIndex + num + 1;
      console.log(this.files);
      // console.log(this.filesPreview);
    },
    fileDeleteButton(e) {
      const name = e.target.getAttribute("name");
      this.files = this.files.filter((data) => data.number !== Number(name));
      // console.log(this.files);
    },

    //취소버튼 - 취소시 메인으로 돌아감.
    //TODO - 버튼 누를시 메인 또는 게시판(지도부분)부분으로 돌아가야됨.(아직 결정안됨.)
    cancelBtn: function () {
      this.router.push({ name: "Main" });
    },
    registBtn: async function () {
      const formData = new FormData();

      // this.insertFormData();
      console.log("final test1 : " + testLat);
      console.log("final test2 :" + testLng);

      this.roomLat = testLat;
      this.roomLng = testLng;

      let bodyData = {
        dongCode: this.dongCode,
        roomType: this.roomType,
        contractType: this.contractType,
        roomAddress: this.roomAddress,
        roomFloor: this.roomFloor,
        contractEndTime: this.contractEndDay,
        tbTitle: this.title,
        tbContent: this.content,
        approvingStatus: "1",
        roomLatitude: this.roomLat,
        roomLongitude: this.roomLng,
      };

      console.log("testX : " + this.roomLat);
      console.log("testY : " + this.roomLng);

      //제이슨 형태

      //파일 전송을 위해 폼데이터에 담기.
      for (const file of this.files) {
        formData.append("uploadFile", file.file);
      }

      formData.append("data", JSON.stringify(bodyData));
      // formData.append("data", bodyData);

      for (const file2 of this.attachments) { 
        console.log(file2);
        formData.append("uploadFile", file2);
      }

      await setTransferBoard(
        formData,
        ({ data }) => {
          console.log(data);
        },
        (error) => {
          console.log(error);
        }
      );
      this.$router.push({ name: "transferPage" });
    },
    selectFile: async function (event) {
      this.files.push(event.target.files);
    },
    insertFormData: function () {
      //시도구군동 이름 가져오기
      this.getAddressName();
      let searchAddress =
        this.sidoName +
        " " +
        this.gugunName +
        " " +
        this.dongName +
        " " +
        this.roomAddress; // 저장할 주소.

      this.roomAddress = searchAddress;

      //입력한 데이터를 폼데이터 형식에 담기.
      /*카카오 지오코더를 이용해서 좌표 변환*/
      var geocoder = new kakao.maps.services.Geocoder();

      // //TODO : 현재는 (구) 주소를 사용하고 있지만, 추후에 도로명 주소를 써야됨(도로명 주소가 좀 더 정확한 위치를 알수 있음.)
      // //TODO : 주소 입력시에는 사용자에게 자유롭게 입력하도록 하면, 잘못된 주소가 있을 수도 있기 때문에, zipcode를 이용하여 검색해서 등록할 수 있도록 함.
      // // let inputAddress = this.sidoName + " " + this.gugunName + " " + this.dongName + " " + this.roomAddress; //입력한 시도구군동과, 사용자가 직접 작성한 나머지 주소를 조합
      // // let inputAddress = "서울특별시 종로구 체부동 51";
      // var callback = function (result, status) {
      //   // 정상적으로 검색이 완료됐으면
      //   if (status === kakao.maps.services.Status.OK) {
      //     console.log(result[0].y);
      //     console.log(result[0].x);
      //   }
      // }

      geocoder.addressSearch(searchAddress, function (result, status) {
        // 정상적으로 검색이 완료됐으면
        if (status === kakao.maps.services.Status.OK) {
          console.log(result[0].y);
          console.log(result[0].x);
          testLat = result[0].y;
          testLng = result[0].x;
        }
      });
    },
    clickHandler() {
      this.$refs.fileInput.click()
    },
    async onSubmit() {
      // const formData = new FormData();
      // formData.append("file", this.attachments[0]);
			// var config = { 
			// 	headers: {
			// 		'Content-Type': 'multipart/form-data',
			// 		'Access-Control-Allow-Origin': '*',
			// 		'Access-Control-Allow-Methods': 'GET, POST'
			// 	}
			// }
      try {
        // await axios.post("http://167.71.6.102:5000/uploads", formData, config)
        //   .then(response => this.message = response)
      } catch (err) {
        this.message = err
      }
    }
  },
};
</script>

<style scoped>
@import "@/assets/css/include/imageUploader.css";
@import "@/assets/css/include/dragAndDrop.css";
</style>
